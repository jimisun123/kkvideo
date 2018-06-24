package com.kkvideo.controller;

import com.kkvideo.enums.VideoStatusEnum;
import com.kkvideo.pojo.Bgm;
import com.kkvideo.pojo.Comments;
import com.kkvideo.pojo.Videos;
import com.kkvideo.service.BgmService;
import com.kkvideo.service.VideoService;
import com.kkvideo.utils.FetchVideoCover;
import com.kkvideo.utils.KkJsonResult;
import com.kkvideo.utils.MergeVideoMp3;
import com.kkvideo.utils.PagedResult;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 12:01 2018-06-12
 * @Modified By:
 */
@RestController
@RequestMapping("/video")
public class VideoController extends BasicController {

    @Autowired
    private BgmService bgmService;

    @Autowired
    private VideoService videoService;


    /**
     * 上传视频
     * @param userId
     * @param bgmId
     * @param videoSeconds
     * @param videoWidth
     * @param videoHeight
     * @param desc
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public KkJsonResult upload(String userId,
                               String bgmId, double videoSeconds,
                               int videoWidth, int videoHeight,
                               String desc,
                               MultipartFile file) throws Exception {
        if (StringUtils.isBlank(userId)) {
            return KkJsonResult.errorMsg("用户id不能为空...");
        }

        String uploadPathDB = "/usersresource/" + userId + "/video";
        String coverPathDB = "/usersresource/" + userId + "/video";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        // 文件上传的最终保存路径
        String finalVideoPath = "";
        String videoOutputName = UUID.randomUUID().toString() + ".mp4";
        try {
            if (file != null) {


                String fileName = file.getOriginalFilename();
                // abc.mp4
                String arrayFilenameItem[] =  fileName.split("\\.");
                String fileNamePrefix = "";
                for (int i = 0 ; i < arrayFilenameItem.length-1 ; i ++) {
                    fileNamePrefix += arrayFilenameItem[i];
                }
                if (StringUtils.isNotBlank(fileName)) {

                    finalVideoPath = FILE_SPACE + uploadPathDB + "/" + videoOutputName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + videoOutputName);
                    coverPathDB = coverPathDB + "/" + videoOutputName + ".jpg";

                    File outFile = new File(finalVideoPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }

            } else {
                return KkJsonResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return KkJsonResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        // 判断bgmId是否为空，如果不为空，
        // 那就查询bgm的信息，并且合并视频，生产新的视频
        if (StringUtils.isNotBlank(bgmId)) {
            Bgm bgm = bgmService.queryBgmById(bgmId);
            String mp3InputPath = FILE_SPACE + bgm.getPath();

            MergeVideoMp3 tool = new MergeVideoMp3(FFMPEG_EXE);
            String videoInputPath = finalVideoPath;


            uploadPathDB = "/usersresource/" + userId + "/video" + "/" + videoOutputName;
            finalVideoPath = FILE_SPACE + uploadPathDB;
            tool.convertor(videoInputPath, mp3InputPath, videoSeconds, finalVideoPath);
        }
        System.out.println("uploadPathDB=" + uploadPathDB);
        System.out.println("finalVideoPath=" + finalVideoPath);

        // 对视频进行截图
        FetchVideoCover videoInfo = new FetchVideoCover(FFMPEG_EXE);
        videoInfo.getCover(finalVideoPath, FILE_SPACE + coverPathDB);

        // 保存视频信息到数据库
        Videos video = new Videos();
        video.setAudioId(bgmId);
        video.setUserId(userId);
        video.setVideoSeconds((float)videoSeconds);
        video.setVideoHeight(videoHeight);
        video.setVideoWidth(videoWidth);
        video.setVideoDesc(desc);
        video.setVideoPath(uploadPathDB);
        video.setCoverPath(coverPathDB);
        video.setStatus(VideoStatusEnum.SUCCESS.value);
        video.setCreateTime(new Date());

        String videoId = videoService.saveVideo(video);

        return KkJsonResult.ok(videoId);


    }

    /**
     * 上传视频封面
     * @param userId
     * @param videoId
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value="/uploadCover", headers="content-type=multipart/form-data")
    public KkJsonResult uploadCover(String userId,
                                       String videoId,
                                       @ApiParam(value="视频封面", required=true)
                                               MultipartFile file) throws Exception {

        if (StringUtils.isBlank(videoId) || StringUtils.isBlank(userId)) {
            return KkJsonResult.errorMsg("视频主键id和用户id不能为空...");
        }

        // 保存到数据库中的相对路径
        String uploadPathDB = "/usersresource/" + userId + "/video";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        // 文件上传的最终保存路径
        String finalCoverPath = "";
        try {
            if (file != null) {

                String fileName = file.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {

                    finalCoverPath = FILE_SPACE + uploadPathDB + "/" + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalCoverPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }

            } else {
                return KkJsonResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return KkJsonResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        videoService.updateVideo(videoId, uploadPathDB);

        return KkJsonResult.ok();
    }

    /**
     *
     * @Description: 分页和搜索查询视频列表
     * isSaveRecord：1 - 需要保存
     * 				 0 - 不需要保存 ，或者为空的时候
     */
    @PostMapping(value="/showAll")
    public KkJsonResult showAll(@RequestBody Videos video, Integer isSaveRecord,
                                   Integer page, Integer pageSize) throws Exception {

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedResult result = videoService.getAllVideos(video, isSaveRecord, page, pageSize);
        return KkJsonResult.ok(result);
    }

    /**
     *获取热搜词
     * @return
     * @throws Exception
     */
    @PostMapping(value="/hot")
    public KkJsonResult hot() throws Exception {
        return KkJsonResult.ok(videoService.getHotwords());
    }

    /**
     * 喜欢某个视频
     * @param userId
     * @param videoId
     * @param videoCreaterId
     * @return
     * @throws Exception
     */
    @PostMapping(value="/userLike")
    public KkJsonResult userLike(String userId, String videoId, String videoCreaterId)
            throws Exception {
        videoService.userLikeVideo(userId, videoId, videoCreaterId);
        return KkJsonResult.ok();
    }

    /**
     * 取消喜欢某个视频
     * @param userId
     * @param videoId
     * @param videoCreaterId
     * @return
     * @throws Exception
     */
    @PostMapping(value="/userUnLike")
    public KkJsonResult userUnLike(String userId, String videoId, String videoCreaterId) throws Exception {
        videoService.userUnLikeVideo(userId, videoId, videoCreaterId);
        return KkJsonResult.ok();
    }

    /**
     * @Description: 我收藏(点赞)过的视频列表
     */
    @PostMapping("/showMyLike")
    public KkJsonResult showMyLike(String userId, Integer page, Integer pageSize) throws Exception {

        if (StringUtils.isBlank(userId)) {
            return KkJsonResult.ok();
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = 6;
        }

        PagedResult videosList = videoService.queryMyLikeVideos(userId, page, pageSize);

        return KkJsonResult.ok(videosList);
    }

    /**
     * @Description: 我关注的人发的视频
     */
    @PostMapping("/showMyFollow")
    public KkJsonResult showMyFollow(String userId, Integer page) throws Exception {

        if (StringUtils.isBlank(userId)) {
            return KkJsonResult.ok();
        }

        if (page == null) {
            page = 1;
        }

        int pageSize = 6;

        PagedResult videosList = videoService.queryMyFollowVideos(userId, page, pageSize);

        return KkJsonResult.ok(videosList);
    }

    /**
     * 保存留言
     * @param comment
     * @param fatherCommentId
     * @param toUserId
     * @return
     * @throws Exception
     */
    @PostMapping("/saveComment")
    public KkJsonResult saveComment(@RequestBody Comments comment,
                                       String fatherCommentId, String toUserId) throws Exception {

        comment.setFatherCommentId(fatherCommentId);
        comment.setToUserId(toUserId);

        videoService.saveComment(comment);
        return KkJsonResult.ok();
    }

    /**
     * 通过videoId查询留言/分页
     * @param videoId
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @PostMapping("/getVideoComments")
    public KkJsonResult getVideoComments(String videoId, Integer page, Integer pageSize) throws Exception {

        if (StringUtils.isBlank(videoId)) {
            return KkJsonResult.ok();
        }

        // 分页查询视频列表，时间顺序倒序排序
        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = 10;
        }

        PagedResult list = videoService.getAllComments(videoId, page, pageSize);

        return KkJsonResult.ok(list);
    }





}
