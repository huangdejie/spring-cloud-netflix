package com.cashbang.configserver.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cashbang.configserver.spring");
        UserRegisterPublisherService userRegisterPublisherService = context.getBean(UserRegisterPublisherService.class);
        User user = new User();
        user.setUsername("张三");
        userRegisterPublisherService.insert(user);
    }

}
