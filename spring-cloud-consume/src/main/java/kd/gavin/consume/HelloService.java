package kd.gavin.consume;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    //断路回调(线程池没有达到最大时，使用线程池中的，线程池达到最大值之后，当使用的LinkedBlockingQueue的时候，达到其最大值之后，会拒绝请求)
    @HystrixCommand(fallbackMethod = "helloFallBack",groupKey = "helloGroup",commandKey = "hello",
    threadPoolProperties = {
         @HystrixProperty(name = "coreSize",value = "15"),
         @HystrixProperty(name = "maxQueueSize",value = "10"),
         @HystrixProperty(name = "queueSizeRejectionThreshold",value = "5")
    },commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"),//指定多久超时，单位毫秒。超时进fallback
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),//判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
    })
    public String helloService(){
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello",String.class).getBody();
    }

    //断路回调(线程池没有达到最大时，使用线程池中的，线程池达到最大值之后，当使用的LinkedBlockingQueue的时候，达到其最大值之后，会拒绝请求)
    @HystrixCommand(fallbackMethod = "helloFallBack",groupKey = "userGroup",commandKey = "helloUser",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "15"),
                    @HystrixProperty(name = "maxQueueSize",value = "10"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold",value = "5")
            })
    public String helloUser(){
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello",String.class).getBody();
    }

    public String helloFallBack(){
        return "error";
    }
}
