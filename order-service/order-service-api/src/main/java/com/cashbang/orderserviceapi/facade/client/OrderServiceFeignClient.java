package com.cashbang.orderserviceapi.facade.client;

import com.cashbang.orderserviceapi.facade.OrderServiceClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
@FeignClient("order-service-provider")
public interface OrderServiceFeignClient extends OrderServiceClient {
}
