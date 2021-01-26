package com.cashbang.orderserviceprovider.controller;

import com.cashbang.orderserviceapi.facade.OrderServiceClient;
import com.cashbang.orderserviceapi.facade.dto.OrderDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
@RestController
public class OrderController implements OrderServiceClient {


    @Override
    public String orders() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Return All Orders";
    }

    @Override
    public int insert(@RequestBody OrderDTO orderDTO) {
        System.out.println("新增订单，订单Id为:"+orderDTO.getOrderId());
        return 1;
    }
}
