package kkvideo.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kkvideo.admin.enums.BGMOperatorTypeEnum;
import kkvideo.admin.mapper.BgmMapper;
import kkvideo.admin.mapper.UsersReportMapperCustom;
import kkvideo.admin.mapper.VideosMapper;
import kkvideo.admin.pojo.Bgm;
import kkvideo.admin.pojo.BgmExample;
import kkvideo.admin.pojo.Videos;
import kkvideo.admin.pojo.vo.Reports;
import kkvideo.admin.service.util.ZKCurator;
import kkvideo.admin.utils.JsonUtils;
import kkvideo.admin.utils.PagedResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 12:41 2018-06-22
 * @Modified By:
 */
@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private BgmMapper bgmMapper;

    @Autowired
    private Sid sid;

    @Autowired
    private ZKCurator zkCurator;

    @Autowired
    private VideosMapper videosMapper;

    @Autowired
    private UsersReportMapperCustom usersReportMapperCustom;


    @Override
    public void addBgm(Bgm bgm) {
        String id = sid.nextShort();
        bgm.setId(id);
        bgmMapper.insert(bgm);
        Map<String, String> map = new HashMap<>();
        map.put("operType", BGMOperatorTypeEnum.ADD.type);
        map.put("path", bgm.getPath());

        zkCurator.sendBgmOperator(id, JsonUtils.objectToJson(map));
    }

    @Override
    public PagedResult queryBgmList(Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);

        BgmExample example = new BgmExample();
        List<Bgm> list = bgmMapper.selectByExample(example);

        PageInfo<Bgm> pageList = new PageInfo<>(list);

        PagedResult result = new PagedResult();
        result.setTotal(pageList.getPages());
        result.setRows(list);
        result.setPage(page);
        result.setRecords(pageList.getTotal());

        return result;
    }

    @Override
    public void deleteBgm(String bgmId) {
        Bgm bgm = bgmMapper.selectByPrimaryKey(bgmId);

        bgmMapper.deleteByPrimaryKey(bgmId);

        /**
         * 调用zookeeper进行通知springboot进行删除
         */
        Map<String, String> map = new HashMap<>();
        map.put("operType", BGMOperatorTypeEnum.DELETE.type);
        map.put("path", bgm.getPath());

        zkCurator.sendBgmOperator(bgmId, JsonUtils.objectToJson(map));

        //删除本地的音乐 TODO
        File file = new File("E:\\worktest\\kkvideo\\kkvideoadmin" + bgm.getPath());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public PagedResult queryReportList(Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);

        List<Reports> reportsList = usersReportMapperCustom.selectAllVideoReport();

        PageInfo<Reports> pageList = new PageInfo<Reports>(reportsList);

        PagedResult grid = new PagedResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(reportsList);
        grid.setPage(page);
        grid.setRecords(pageList.getTotal());

        return grid;
    }

    @Override
    public void updateVideoStatus(String videoId, Integer status) {

        Videos video = new Videos();
        video.setId(videoId);
        video.setStatus(status);
        videosMapper.updateByPrimaryKeySelective(video);
    }
}
