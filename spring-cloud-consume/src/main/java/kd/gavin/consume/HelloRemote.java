package kd.gavin.consume;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kd_gavin on 2017/9/21,9:22.
 *
 * @dicription
 */
@FeignClient(name = "SERVICE-HELLO")
public interface HelloRemote {
    @RequestMapping(value = "/hello1")
    public String hello(@RequestParam(value = "name") String name);
}
