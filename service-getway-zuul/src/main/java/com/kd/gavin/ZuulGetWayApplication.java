package com.kd.gavin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by kd_gavin on 2017/9/21,14:24.
 *
 * @dicription
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGetWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGetWayApplication.class,args);
    }
}
