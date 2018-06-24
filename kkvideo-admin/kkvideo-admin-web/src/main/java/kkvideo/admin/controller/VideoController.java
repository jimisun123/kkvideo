package kkvideo.admin.controller;

import kkvideo.admin.enums.VideoStatusEnum;
import kkvideo.admin.pojo.Bgm;
import kkvideo.admin.service.VideoService;
import kkvideo.admin.utils.KkJsonResult;
import kkvideo.admin.utils.PagedResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 11:51 2018-06-22
 * @Modified By:
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Value("${FILE_SPACE}")
    private String FILE_SPACE;

    @Autowired
    private VideoService videoService;


    /**
     * 分页查询所有bgm使用Pagehelper
     * @param page
     * @return
     */
    @PostMapping("/queryBgmList")
    @ResponseBody
    public PagedResult queryBgmList(Integer page) {
        return videoService.queryBgmList(page, 10);
    }


    /**
     * 跳转背景音乐列表
     *
     * @return
     */
    @RequestMapping("/showBgmList")
    public String showBgmList() {
        return "video/bgmList";
    }

    /**
     * 删除bgm
     * @param bgmId
     * @return
     */
    @PostMapping("/delBgm")
    @ResponseBody
    public KkJsonResult delBgm(String bgmId) {
        videoService.deleteBgm(bgmId);
        return KkJsonResult.ok();
    }

    /**
     * 跳转到添加背景音乐地址
     *
     * @return
     */
    @RequestMapping("/showAddBgm")
    public String showAddBgm() {
        return "video/addBgm";
    }

    /**
     * 添加bgm
     *
     * @param bgm
     * @return
     */
    @PostMapping("/addBgm")
    @ResponseBody
    public KkJsonResult addBgm(Bgm bgm) {
        videoService.addBgm(bgm);
        return KkJsonResult.ok();
    }

    /**
     * 后台上传Bgm音乐
     *
     * @param files
     * @return
     * @throws Exception
     */
    @PostMapping("/bgmUpload")
    @ResponseBody
    public KkJsonResult bgmUpload(@RequestParam("file") MultipartFile[] files) throws Exception {

        // 文件保存的命名空间
       // String fileSpace = "E:" + File.separator + "worktest" + File.separator + "kkvideo" + File.separator + "kkvideoadmin";

        // 保存到数据库中的相对路径
        String uploadPathDB = File.separator + "bgm";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {

                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalPath = FILE_SPACE + uploadPathDB + File.separator + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += (File.separator + fileName);

                    File outFile = new File(finalPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
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

        return KkJsonResult.ok(uploadPathDB);
    }

    /**
     * 跳转举报页面
     * @return
     */
    @GetMapping("/showReportList")
    public String showReportList() {
        return "video/reportList";
    }

    /**
     * 查询举报列表
     * @param page
     * @return
     */
    @PostMapping("/reportList")
    @ResponseBody
    public PagedResult reportList(Integer page) {

        PagedResult result = videoService.queryReportList(page, 10);
        return result;
    }

    /**
     * 更逊举报状态
     * @param videoId
     * @return
     */
    @PostMapping("/forbidVideo")
    @ResponseBody
    public KkJsonResult forbidVideo(String videoId) {

        videoService.updateVideoStatus(videoId, VideoStatusEnum.FORBID.value);
        return KkJsonResult.ok();
    }


}
