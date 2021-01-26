package com.cashbang.userserviceprovider.controller;

import com.cashbang.orderserviceapi.facade.client.OrderServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangdj
 * @Date: 2021/1/25
 */
@RestController
public class HystrixFeignController {

    @Autowired
    private OrderServiceFeignClient feignClient;

    @GetMapping("/hystrix/order")
    public String order(){
        return feignClient.orders();
    }

}
