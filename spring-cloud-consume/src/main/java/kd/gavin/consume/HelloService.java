package kd.gavin.consume;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kd_gavin
 * @time 2017/10/27,13:36
 * @dicription
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //断路回调
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService(){
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello",String.class).getBody();
    }

    public String helloFallBack(){
        return "error";
    }
}
