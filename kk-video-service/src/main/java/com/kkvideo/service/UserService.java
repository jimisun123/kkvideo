package com.kkvideo.service;

import com.kkvideo.pojo.Users;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 22:45 2018-06-10
 * @Modified By:
 */
public interface UserService {

    Boolean queryUserExistByUsername(String username);

    void saveUser(Users users);


    /**
     * @Description: 用户登录，根据用户名和密码查询用户
     */
    public Users queryUserForLogin(String username, String password);

    /**
     * @Description: 用户修改信息
     */
    public void updateUserInfo(Users user);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public Users queryUserInfo(String userId);


}
