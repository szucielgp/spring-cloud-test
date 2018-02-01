package com.kd.gavin;

import com.kd.gavin.filter.ParamFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

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

    //要在主类中配置自定义filter
    @Bean
    public ParamFilter paramFilter(){
        return new ParamFilter();
    }
}
