package kkvideo.admin.service;

import kkvideo.admin.pojo.Users;
import kkvideo.admin.utils.PagedResult;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 00:18 2018-06-23
 * @Modified By:
 */
public interface UserService {

    public PagedResult queryUsers(Users user, Integer page, Integer pageSize);
}
