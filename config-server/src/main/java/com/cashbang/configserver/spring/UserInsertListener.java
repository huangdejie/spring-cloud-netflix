package com.cashbang.configserver.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 插入用户信息
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Component
public class UserInsertListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String) userRegisterEvent.getSource();
        System.out.println("用户注册");
        User user = JSON.parseObject(source,User.class);
        //insertDB
    }
}
