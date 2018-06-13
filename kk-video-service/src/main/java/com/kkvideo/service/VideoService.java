package com.kkvideo.service;

import com.kkvideo.pojo.Videos;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 20:16 2018-06-12
 * @Modified By:
 */
public interface VideoService {

    public String saveVideo(Videos videos);

    public void updateVideo(String videoId,String coverPath);
}
