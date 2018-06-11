package com.kkvideo.controller;

import com.kkvideo.pojo.Users;
import com.kkvideo.service.UserService;
import com.kkvideo.vo.UsersVo;
import com.kkvideo.utils.KkJsonResult;
import com.kkvideo.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author:jimisun
 * @Description:用户注册和登陆的controller
 * @Date:Created in 21:23 2018-06-10
 * @Modified By:
 */
@RestController
@Api(value = "用户登陆和注册的接口",tags = {"注册和登陆的controller"})
public class RegistLoginController extends BasicController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户注册",notes = "用户注册的接口")
    @PostMapping("/regist")
    public KkJsonResult register(@RequestBody Users user) throws Exception {

        //校验用户传递的参数是否正确
        if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
            return KkJsonResult.errorMsg("用户名或密码不能为空");
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
            return KkJsonResult.errorMsg("用户名已经存在！");
        }

        user.setPassword("");
        UsersVo usersVo = setUserRedisSessionToken(user);
        return KkJsonResult.ok(usersVo);
    }

    @ApiOperation(value="用户登录", notes="用户登录的接口")
    @PostMapping("/login")
    public KkJsonResult login(@RequestBody Users user) throws Exception {

        String username = user.getUsername();
        String password = user.getPassword();

        // 1. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return KkJsonResult.ok("用户名或密码不能为空...");
        }

        // 2. 判断用户是否存在
        Users userResult = userService.queryUserForLogin(username,
                MD5Utils.getMD5Str(user.getPassword()));

        // 3. 返回
        if (userResult != null) {
            userResult.setPassword("");
            UsersVo usersVo = setUserRedisSessionToken(userResult);
            return KkJsonResult.ok(usersVo);

        } else {
            return KkJsonResult.errorMsg("用户名或密码不正确, 请重试...");
        }
    }


    public UsersVo setUserRedisSessionToken(Users userModel) {
        String uniqueToken = UUID.randomUUID().toString().replace("-","");
        redis.set(USER_REDIS_SESSION + ":" + userModel.getId(), uniqueToken, 1000 * 60 * 30);

        UsersVo userVO = new UsersVo();
        BeanUtils.copyProperties(userModel, userVO);
        userVO.setUserToken(uniqueToken);
        return userVO;
    }

    @ApiOperation(value="用户注销", notes="用户注销的接口")
    @ApiImplicitParam(name="userId", value="用户id", required=true,
            dataType="String", paramType="query")
    @PostMapping("/logout")
    public KkJsonResult logout(String userId) throws Exception {
        redis.del(USER_REDIS_SESSION + ":" + userId);
        return KkJsonResult.ok();
    }


}
