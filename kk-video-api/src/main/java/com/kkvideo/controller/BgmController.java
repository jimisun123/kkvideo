package com.kkvideo.controller;

import com.kkvideo.pojo.Bgm;
import com.kkvideo.service.BgmService;
import com.kkvideo.utils.KkJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 11:09 2018-06-12
 * @Modified By:
 */
@RestController
@Api(value = "背景音乐的Controller",tags = {"背景音乐api"})
@RequestMapping("/bgm")
public class BgmController {

    @Autowired
    private BgmService bgmService;


    @PostMapping("/list")
    @ApiOperation(value = "查询背景音乐列表",notes = "查询背景音乐列表")
    public KkJsonResult list(){
        return KkJsonResult.ok(bgmService.queryBgmList());
    }



}
