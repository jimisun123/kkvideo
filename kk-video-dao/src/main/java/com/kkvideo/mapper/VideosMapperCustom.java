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

}