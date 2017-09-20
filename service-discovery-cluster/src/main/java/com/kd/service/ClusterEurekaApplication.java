package com.kd.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by kd_gavin on 2017/9/20,14:33.
 *
 * @dicription
 */
@SpringBootApplication
@EnableEurekaServer
public class ClusterEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClusterEurekaApplication.class,args);
    }
}
