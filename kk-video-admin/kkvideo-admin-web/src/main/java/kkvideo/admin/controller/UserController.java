package kkvideo.admin.controller;

import kkvideo.admin.bean.AdminUser;
import kkvideo.admin.pojo.Users;
import kkvideo.admin.service.UserService;
import kkvideo.admin.utils.KkJsonResult;
import kkvideo.admin.utils.PagedResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 10:54 2018-06-22
 * @Modified By:
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @Value("${adminusername}")
    private String adminUsername;

    @Value("${adminpassword}")
    private String adminPassword;

    @Autowired
    private UserService userService;


    /**
     * 用户登陆
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public KkJsonResult userLogin(String username, String password,
                                     HttpServletRequest request, HttpServletResponse response) {


        // TODO 模拟登陆
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return KkJsonResult.errorMap("用户名和密码不能为空");
        } else if (username.equals(adminUsername) && password.equals(adminPassword)) {
            String token = UUID.randomUUID().toString();
            AdminUser user = new AdminUser(username, password, token);
            request.getSession().setAttribute("existUser", user);
            return KkJsonResult.ok();
        }

        return KkJsonResult.errorMsg("登陆失败，请重试...");
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("sessionUser");
        return "login";
    }


    /**
     * 跳转用户列表
     * @return
     */
    @GetMapping("/showList")
    public String showList() {
        return "users/usersList";
    }

    /**
     * 查询用户列表
     * @param user
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PagedResult list(Users user,Integer page) {
        PagedResult result = userService.queryUsers(user, page == null ? 1 : page, 10);
        return result;
    }
}
