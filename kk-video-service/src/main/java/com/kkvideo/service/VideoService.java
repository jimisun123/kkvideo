package com.kkvideo.service;

import com.kkvideo.pojo.Videos;
import com.kkvideo.utils.PagedResult;
import com.kkvideo.vo.VideosVo;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 20:16 2018-06-12
 * @Modified By:
 */
public interface VideoService {

    public String saveVideo(Videos videos);

    public void updateVideo(String videoId,String coverPath);

    public PagedResult getAllVideos(Videos video, Integer isSaveRecord,Integer page,Integer pageSize);
    /**
     * @Description: 获取热搜词列表
     */
    public List<String> getHotwords();

}
