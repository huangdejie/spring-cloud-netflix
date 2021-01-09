package com.cashbang.orderserviceapi.facade;

import com.cashbang.orderserviceapi.facade.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
public interface OrderServiceClient {

    @GetMapping("/orders")
    String orders();

    @PostMapping("/order")
    int insert(OrderDTO orderDTO);

}
