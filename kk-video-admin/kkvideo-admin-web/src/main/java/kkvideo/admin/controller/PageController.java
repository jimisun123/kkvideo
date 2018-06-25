package kkvideo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 00:02 2018-06-22
 * @Modified By:
 */
@Controller
public class PageController {

    /**
     * 跳转后台首页
     * @return
     */
    @RequestMapping("/center")
    public String goCenter(){
        return "center";
    }

    /**
     * 跳转用户登陆页面
     * @return
     */
    @GetMapping("/login")
    public String gologin(){
        return "login";
    }
}

