package com.cashbang.orderserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class OrderServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(OrderServiceProviderApplication.class);
        Map<String,Object> map = new HashMap<>();
        map.put("yourname","yoyo");
        application.setDefaultProperties(map);
        application.run(args);
//        SpringApplication.run(OrderServiceProviderApplication.class, args);
    }

}
