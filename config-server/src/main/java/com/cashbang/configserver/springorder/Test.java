package com.cashbang.configserver.springorder;

import com.cashbang.configserver.spring.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cashbang.configserver.springorder");
        UserRegister1PublisherService service = context.getBean(UserRegister1PublisherService.class);
        User user = new User();
        user.setUsername("王武");
        service.insert(user);
    }

}
