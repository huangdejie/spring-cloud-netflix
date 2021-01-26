package com.cashbang.configserver.springorder;

import com.cashbang.configserver.spring.User;
import com.cashbang.configserver.spring.UserRegisterEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Component
public class UserInsert1Listener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == UserRegisterEvent.class;
    }


    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) applicationEvent;
        System.out.println("注册用户");
    }
}
