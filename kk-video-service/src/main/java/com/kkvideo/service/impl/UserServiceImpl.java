package com.kkvideo.service.impl;

import com.kkvideo.mapper.UsersMapper;
import com.kkvideo.pojo.Users;
import com.kkvideo.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.cs.FastCharsetProvider;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 22:46 2018-06-10
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean queryUserExistByUsername(String username) {
        Users users = new Users();
        users.setUsername(username);
        Users result = usersMapper.selectOne(users);
        return result == null?false:true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(Users users) {

        String userid = sid.nextShort();
        users.setId(userid);
        usersMapper.insert(users);

    }
}
