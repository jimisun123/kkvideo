package com.kkvideo.service;

import com.kkvideo.pojo.Users;
import com.kkvideo.pojo.UsersReport;

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

    /**
     * @Description: 查询用户是否喜欢点赞视频
     */
    public boolean isUserLikeVideo(String userId, String videoId);

    /**
     * @Description: 增加用户和粉丝的关系
     */
    public void saveUserFanRelation(String userId, String fanId);

    /**
     * @Description: 删除用户和粉丝的关系
     */
    public void deleteUserFanRelation(String userId, String fanId);

    /**
     * @Description: 查询用户是否关注
     */
    public boolean queryIfFollow(String userId, String fanId);

    /**
     * @Description: 举报用户
     */
    public void reportUser(UsersReport userReport);




}
