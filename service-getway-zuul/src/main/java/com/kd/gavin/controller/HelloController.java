package com.kd.gavin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kd_gavin
 * @time 2017/10/31,14:26
 * @dicription
 */
@RestController
public class HelloController {

    @RequestMapping("/local/hello")
    public String hello(){
        return "hello,local";
    }
}
