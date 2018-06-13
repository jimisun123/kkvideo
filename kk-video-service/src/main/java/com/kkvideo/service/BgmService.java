package com.kkvideo.service;

import com.kkvideo.pojo.Bgm;
import org.hibernate.validator.constraints.ModCheck;

import java.util.List;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 11:04 2018-06-12
 * @Modified By:
 */
public interface BgmService {

    public List<Bgm> queryBgmList();

    public Bgm queryBgmById(String bgmId);
}
