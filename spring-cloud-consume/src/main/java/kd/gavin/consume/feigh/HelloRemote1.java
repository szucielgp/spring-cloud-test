package kd.gavin.consume.feigh;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kd_gavin
 * @time 2018/3/1,13:46
 * @dicription
 */
@FeignClient(name = "hello-service-1")
public interface HelloRemote1 {
    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello1(@RequestParam("name") String name);
}
