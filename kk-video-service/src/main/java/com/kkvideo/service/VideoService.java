package com.kkvideo.service;

import com.kkvideo.pojo.Comments;
import com.kkvideo.pojo.Videos;
import com.kkvideo.utils.PagedResult;

import java.util.List;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 20:16 2018-06-12
 * @Modified By:
 */
public interface VideoService {

    /**
     * 上传视频
     * @param videos
     * @return
     */
    public String saveVideo(Videos videos);

    /**
     * 更新视频封面
     * @param videoId
     * @param coverPath
     */
    public void updateVideo(String videoId,String coverPath);

    /**
     * @Description: 分页查询视频列表
     */
    public PagedResult getAllVideos(Videos video, Integer isSaveRecord,
                                    Integer page, Integer pageSize);
    /**
     * @Description: 获取热搜词列表
     */
    public List<String> getHotwords();

    /**
     * @Description: 用户喜欢/点赞视频
     */
    public void userLikeVideo(String userId, String videoId, String videoCreaterId);

    /**
     * @Description: 用户不喜欢/取消点赞视频
     */
    public void userUnLikeVideo(String userId, String videoId, String videoCreaterId);

    /**
     * @Description: 查询我喜欢的视频列表
     */
    public PagedResult queryMyLikeVideos(String userId, Integer page, Integer pageSize);

    /**
     * @Description: 查询我关注的人的视频列表
     */
    public PagedResult queryMyFollowVideos(String userId, Integer page, Integer pageSize);

    /**
     * @Description: 用户留言
     */
    public void saveComment(Comments comment);

    /**
     * @Description: 留言分页
     */
    public PagedResult getAllComments(String videoId, Integer page, Integer pageSize);

}
