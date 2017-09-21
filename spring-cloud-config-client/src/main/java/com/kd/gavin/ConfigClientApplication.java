package com.kd.gavin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by kd_gavin on 2017/9/21,10:57.
 *只需要将server端当做一个服务注册到eureka中，client端去eureka中去获取配置中心server端的服务既可。
 * @dicription
 */


@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
