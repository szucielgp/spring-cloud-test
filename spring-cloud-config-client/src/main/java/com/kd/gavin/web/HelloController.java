package com.kd.gavin.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kd_gavin on 2017/9/21,11:04.
 *
 * @dicription
 */

@RestController
@RefreshScope
public class HelloController {

    /*
    * @RefreshScope 以post请求的方式来访问http://localhost:10002/refresh 就会更新修改后的配置文件
    * */

    @Value("${cloud.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
