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

}
