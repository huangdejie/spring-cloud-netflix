package com.cashbang.configserver.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cashbang.configserver.event");
        context.start();
        HelloWorld obj = context.getBean(HelloWorld.class);
        System.out.println(obj.getMessage());
        context.stop();
    }

}
