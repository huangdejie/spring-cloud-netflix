package com.cashbang.configserver.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册成功发送短信
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Component
public class NotifyUserListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String) userRegisterEvent.getSource();
        System.out.println("注册成功，发送短信通知");
        User user = JSON.parseObject(source,User.class);
        //send sms
    }
}
