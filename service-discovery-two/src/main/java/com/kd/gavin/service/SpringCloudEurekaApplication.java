package com.kd.gavin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by kd_gavin on 2017/9/20,13:45.
 *
 * @dicription
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication.class,args);
    }
}
