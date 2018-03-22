package com.kd.gavin.turbine.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author kd_gavin
 * @time 2018/3/12,14:58
 * @dicription
 */
@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineKafkaApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(TurbineKafkaApplication.class,args);
    }
}
