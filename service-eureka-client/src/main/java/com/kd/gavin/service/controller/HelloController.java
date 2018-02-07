package com.kd.gavin.service.controller;


import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * Created by kd_gavin on 2017/9/19,12:28.
 *
 * @dicription
 */

@RestController
public class HelloController {
    protected Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Value("${server.port}")
    private int serverPort = 0;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(HttpServletRequest request) throws InterruptedException {
        Cookie[] cookies = request.getCookies();//经过zuul网关，这里是取不到cookie的，通过sensitive-headers 可以去到cookie的值
        this.logger.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));
        //Hystrix默认的时间为2000ms
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleep time:"+sleepTime);
        Thread.sleep(sleepTime);
        return "Hello, Spring Cloud! My port is " + String.valueOf(serverPort);
    }

    @RequestMapping(value = "/hello1")
    public String hello(@RequestParam String name){//http://localhost:8200/hello1?name=aa RequestParam
        return "hello"+name;
    }


}
