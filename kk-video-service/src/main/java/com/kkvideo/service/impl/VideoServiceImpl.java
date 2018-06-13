package com.kkvideo.service.impl;

import com.kkvideo.mapper.VideosMapper;
import com.kkvideo.pojo.Videos;
import com.kkvideo.service.VideoService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 20:16 2018-06-12
 * @Modified By:
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private Sid sid;

    @Autowired
    private VideosMapper videosMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String saveVideo(Videos video) {

        String id = sid.nextShort();
        video.setId(id);
        videosMapper.insertSelective(video);
        return id;
    }

    @Override
    public void updateVideo(String videoId, String coverPath) {
        Videos videos = new Videos();
        videos.setCoverPath(coverPath);
        videos.setId(videoId);
        videosMapper.updateByPrimaryKeySelective(videos);
    }
}
