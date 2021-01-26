package com.cashbang.configserver.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册成功给用户生成推荐商品
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Component
public class RecommendListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String) userRegisterEvent.getSource();
        System.out.println("推送商品");
        User user = JSON.parseObject(source,User.class);
        //generate recommend commodity
    }
}
