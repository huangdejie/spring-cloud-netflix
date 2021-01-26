package com.cashbang.orderserviceprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
@RefreshScope
@RestController
public class ConfigController {

    private int i = 0;

    @Value("${custom.property.hello}")
    private String txt;

    @Value("${custom.property.hi}")
    private String hi;

    @Value("${province}")
    private String province;

    @Value("${yourname}")
    private String yourname;

    @Value("${teacher.name}")
    private String teacherName;

    @Value("${application.test}")
    private String applicationTest;

    @Value("${default.name}")
    private String defaultName;

    @GetMapping("/province")
    public String province(){
        return province;
    }

    @GetMapping("/defaultTest")
    public String defaultTest(){
        return yourname;
    }

    @GetMapping("/teacher")
    public String teacher(){
        return teacherName;
    }

    @GetMapping("/add")
    public int add(){
        i++;
        return i;
    }

    @GetMapping("/json")
    public String json(){
        return txt;
    }

    @GetMapping("/applicationTest")
    public String applicationTest(){
        return applicationTest;
    }

    @GetMapping("/defaultName")
    public String defaultName(){
        return defaultName;
    }

    @GetMapping("/hi")
    public String hi(){
        return hi;
    }


}
