package com.cashbang.orderserviceprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
@RestController
public class ConfigController {

    @Value("${province}")
    private String province;

    @GetMapping("/province")
    public String province(){
        return province;
    }

}
