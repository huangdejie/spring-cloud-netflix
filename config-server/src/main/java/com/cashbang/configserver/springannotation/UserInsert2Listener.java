package com.cashbang.configserver.springannotation;

import com.cashbang.configserver.spring.UserRegisterEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Component
public class UserInsert2Listener {

    @Order(1)
    @EventListener(classes = UserRegisterEvent.class)
    public void checkUserInfo(UserRegisterEvent event){
        System.out.println("用户注册");
    }

}
