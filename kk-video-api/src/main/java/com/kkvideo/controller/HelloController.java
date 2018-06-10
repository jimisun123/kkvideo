package com.kkvideo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 21:23 2018-06-10
 * @Modified By:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sysHello() {
        return "hello kkvideo";
    }
}
