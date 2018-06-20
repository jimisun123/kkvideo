package com.kkvideo.mapper;

import com.kkvideo.pojo.Videos;
import com.kkvideo.utils.MyMapper;
import com.kkvideo.vo.VideosVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideosMapperCustom extends MyMapper<Videos> {

    /**
     * @Description: 条件查询所有视频列表
     */
    public List<VideosVo> queryAllVideos(@Param("videoDesc") String videoDesc,
                                         @Param("userId") String userId);

    /**
     * 喜欢视频
     * @param videoId
     */
    public void addVideoLikeCount(String videoId);


    /**
     * 取消喜欢视频
     * @param videoId
     */
    public void reduceVideoLikeCount(String videoId);

    /**
     * @Description: 查询点赞视频
     */
    public List<VideosVo> queryMyLikeVideos(@Param("userId") String userId);

    /**
     * @Description: 查询关注的视频
     */
    public List<VideosVo> queryMyFollowVideos(String userId);




}

