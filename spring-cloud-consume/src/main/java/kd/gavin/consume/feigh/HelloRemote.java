package kd.gavin.consume.feigh;

import com.kd.gavin.po.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kd_gavin on 2017/9/21,9:22.
 *
 * @dicription @FeignClient(name = "SERVICE-HELLO") 这里就相当于是给Hystrix划定了一个线程池
 */
@FeignClient(name = "SERVICE-HELLO")
public interface HelloRemote {
    @RequestMapping(value = "/hello1")
    public String hello(@RequestParam(value = "name") String name);

    //通过RequestParam 方式进行参数传递
    @RequestMapping(value = "/user1")
    User getUser(@RequestParam(value = "id") Long id );

    //通过PathVariable 方式进行参数传递(要加value参数)
    @RequestMapping(value = "/user2/{id}")
    User getUser1(@PathVariable(value = "id") Long id );
}
