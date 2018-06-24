package kkvideo.admin.service;

import kkvideo.admin.pojo.Bgm;
import kkvideo.admin.utils.PagedResult;
import org.springframework.stereotype.Service;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 12:42 2018-06-22
 * @Modified By:
 */
public interface VideoService {

    public void addBgm(Bgm bgm);
    public PagedResult queryBgmList(Integer page,Integer pageSize);
    public void deleteBgm(String bgmId);


    public PagedResult queryReportList(Integer page, Integer pageSize);

    public void updateVideoStatus(String videoId, Integer status);
}
