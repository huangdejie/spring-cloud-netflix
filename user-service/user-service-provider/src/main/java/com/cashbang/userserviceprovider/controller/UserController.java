package com.cashbang.userserviceprovider.controller;

import com.cashbang.orderserviceapi.facade.client.OrderServiceFeignClient;
import com.cashbang.orderserviceapi.facade.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
@RestController()
public class UserController {

    @Resource
    private OrderServiceFeignClient orderServiceFeignClient;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/orders")
    public String orders(){
        System.out.println("*****获取订单*****");
        String orders = orderServiceFeignClient.orders();
        return orders;
    }

    @PostMapping("/order")
    public String order(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("ORDER"+new Random().nextInt());
        orderDTO.setOrderAddress("江苏省南京市铁心桥街道春江新城鸿觉坊15栋2单元");
        orderDTO.setPrivice(199.99D);
        orderServiceFeignClient.insert(orderDTO);
        return "SUCCESS";
    }



}
