package com.kkvideo.controller;

import com.kkvideo.mapper.UsersMapper;
import com.kkvideo.pojo.Users;
import com.kkvideo.service.UserService;
import com.kvideo.utils.KkJsonResult;
import com.kvideo.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jimisun
 * @Description:用户注册和登陆的controller
 * @Date:Created in 21:23 2018-06-10
 * @Modified By:
 */
@RestController
@Api(value = "用户登陆和注册的接口",tags = {"注册和登陆的controller"})
public class RegistLoginController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户注册",notes = "用户注册的接口")
    @PostMapping("/regist")
    public KkJsonResult register(@RequestBody Users user) throws Exception {

        //校验用户传递的参数是否正确
        if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
            return KkJsonResult.errorException("用户名或密码不能为空");
        }

        //判断用户是否存在 不存在既然注册
        Boolean flag = userService.queryUserExistByUsername(user.getUsername());
        if(!flag){
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setReceiveLikeCounts(0);
            //存储
            userService.saveUser(user);
        }else{
            return KkJsonResult.errorException("用户名已经存在！");
        }

        return KkJsonResult.ok();
    }
}
