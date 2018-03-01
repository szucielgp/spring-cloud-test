package kd.gavin.consume.controller;

import kd.gavin.consume.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kd_gavin on 2017/9/19,19:51.
 *
 * @dicription
 */

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    //断路器测试
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello",String.class).getBody();
    }



    /*断路器测试*/
    @RequestMapping(value = "/ribbon-consume",method = RequestMethod.GET)
    public String hello1(){
        return helloService.helloService();
    }

    /*断路器测试*/
    @RequestMapping(value = "/ribbon-consume-user",method = RequestMethod.GET)
    public String helloUser(){
        return helloService.helloUser();
    }
}
