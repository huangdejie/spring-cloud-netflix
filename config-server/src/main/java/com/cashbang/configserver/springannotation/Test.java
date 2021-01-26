package com.cashbang.configserver.springannotation;

import com.cashbang.configserver.spring.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cashbang.configserver.springannotation");
        UserRegister2PublisherService service = context.getBean(UserRegister2PublisherService.class);
        service.insert(new User());
    }

}
