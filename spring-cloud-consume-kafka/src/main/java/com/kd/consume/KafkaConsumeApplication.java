package com.kd.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by kd_gavin on 2017/9/21,9:17.
 *
 * @dicription
 */

@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class KafkaConsumeApplication {


    /*
    * Feign是一个声明式Web Service客户端。使用Feign能让编写Web Service客户端更加简单,
    * 它的使用方法是定义一个接口，然后在上面添加注解，同时也支持JAX-RS标准的注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，
    * 使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。
    * */

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumeApplication.class,args);
    }

   /* @Bean
    public Feign.Builder feignHystrixBuilder() {
        return HystrixFeign.builder().setterFactory(new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                return HystrixCommand.Setter
                        // 控制 RemoteProductService 下,所有方法的Hystrix Configuration, 超时配置
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("hello-service-1"))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000)
                        );
            }
        });
    }*/
}
