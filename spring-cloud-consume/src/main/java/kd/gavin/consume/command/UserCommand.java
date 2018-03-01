package kd.gavin.consume.command;


import com.kd.gavin.po.User;
import com.netflix.hystrix.HystrixCommand;
import kd.gavin.consume.feigh.HelloRemote;
import org.springframework.web.client.RestTemplate;

/**
 * @author kd_gavin
 * @time 2018/2/7,10:59
 * @dicription
 */
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private HelloRemote helloRemote;//通过feiclient 获取数据
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    public UserCommand(Setter setter, RestTemplate restTemplate, HelloRemote helloRemote, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.helloRemote = helloRemote;
        this.id = id;
    }

    /* @Override
    protected User getFallback() {
        return new User(1102L,"haha",23,1);
    }*/

  /*  @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://SERVICE-HELLO/user1",User.class,id);
    }*/

  // 通过FeignClient进行方法调用
    @Override
    protected User run() throws Exception {
        return helloRemote.getUser1(id);
        //通过RequestParam 方式进行参数传递
        //return helloRemote.getUser(id);
    }

    /*//通过 restTemplate 进行方法调用
    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://SERVICE-HELLO/user/{id}",User.class,id);
    }*/
}
