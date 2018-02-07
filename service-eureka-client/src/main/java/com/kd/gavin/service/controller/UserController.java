package com.kd.gavin.service.controller;

import com.kd.gavin.po.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author kd_gavin
 * @time 2018/2/7,16:09
 * @dicription
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setAge(25);
        user.setName("gavin002");
        user.setSex(0);
        return user;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User getUser1(){
        User user = new User();
        user.setId(1102L);
        user.setAge(245);
        user.setName("gavin");
        user.setSex(1);
        return user;
    }

    //对应 consume 中的 通过RequestParam freignclient 进行参数调用
    @RequestMapping(value = "/user1",method = RequestMethod.GET)
    public User getUser2(@RequestParam Long id){
        User user = new User();
        user.setId(id);
        user.setAge(245);
        user.setName("gavin");
        user.setSex(1);
        return user;
    }

    //对应 consume 中的 通过PathVariablefreignclient 进行参数调用
    @RequestMapping(value = "/user2/{id}",method = RequestMethod.GET)
    public User getUser3(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setAge(245666);
        user.setName("gavin001");
        user.setSex(1);
        return user;
    }
}
