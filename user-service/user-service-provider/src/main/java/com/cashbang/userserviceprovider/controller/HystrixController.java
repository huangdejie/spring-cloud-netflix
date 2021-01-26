package com.cashbang.userserviceprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: huangdj
 * @Date: 2021/1/22
 */
@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 熔断触发降级
     * @param num
     * @return
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    },fallbackMethod = "fallback")
    @GetMapping("/hystrix/fuse/{num}")
    public String fuse(@PathVariable("num") int num){
        if(num % 2 == 0){
            return "正常访问。";
        }
        String result = restTemplate.getForObject("http://localhost:8088/orders",String.class);
        return result;
    }

    public String fallback(int num){
        return "系统繁忙，请稍后再试！";
    }

    /**
     * orders睡眠10s，restTemplate超时设置为8s
     * 超时触发降级
     * @return
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "9000")
    },fallbackMethod = "timeoutFallback")
    @GetMapping("/hystrix/timeout")
    public String timeout(){
        String result = restTemplate.getForObject("http://localhost:8088/orders",String.class);
        return result;
    }

    public String timeoutFallback(){
        return "系统超时，请稍后重试！";
    }

}
