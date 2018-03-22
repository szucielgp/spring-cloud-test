package com.kd.consume.controller;


import com.kd.consume.feign.HelloRemote;
import com.kd.consume.feign.HelloRemote1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kd_gavin
 * @time 2018/2/27,17:14
 * @dicription
 */
@RestController
public class FeignClientController {


    @Autowired
    private HelloRemote helloRemote;

    @Autowired
    private HelloRemote1 helloRemote1;

    //http://localhost:8195/hello/aa
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

    //http://localhost:8195/feigh-hello
    @RequestMapping(value = "/feigh-hello")
    public String hello1() {
        return helloRemote1.hello();
    }


    @RequestMapping(value = "/feigh-hello-1",method = RequestMethod.GET)
    public String hello11(@RequestParam String name) {
        return helloRemote1.hello1(name);
    }
}
