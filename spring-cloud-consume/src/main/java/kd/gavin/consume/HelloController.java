package kd.gavin.consume;

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

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello",String.class).getBody();
    }
}
