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
public class NotifyUser1Listener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
//        System.out.println("event:"+(aClass==UserRegisterEvent.class));

        return aClass == UserRegisterEvent.class;
//        return true;
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("发送短信通知");
    }
}
