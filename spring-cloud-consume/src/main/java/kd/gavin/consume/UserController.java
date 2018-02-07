package kd.gavin.consume;

import com.kd.gavin.po.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import kd.gavin.consume.command.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author kd_gavin
 * @time 2018/2/7,10:49
 * @dicription
 */

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping(value = "/user/{id}")
    public User getUserById(@PathVariable Long id){

      //  UserCommand user = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("test")),restTemplate,id);
        UserCommand user = new UserCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("test")),restTemplate,helloRemote,id);
        return user.execute();
    }
}
