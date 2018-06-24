package com.kkvideo;

import com.kkvideo.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 11:56 2018-06-16
 * @Modified By:
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Bean
    public UserInterceptor userInterceptor(){
        return new UserInterceptor();
    }

   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/user/**").excludePathPatterns("/user/queryPublisher");
    }

    @Bean(initMethod="init")
    public ZKCuratorClient zkCuratorClient() {
        return new ZKCuratorClient();
    }

}
