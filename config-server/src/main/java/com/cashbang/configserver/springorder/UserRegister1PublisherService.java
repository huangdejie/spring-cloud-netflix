package com.cashbang.configserver.springorder;

import com.alibaba.fastjson.JSON;
import com.cashbang.configserver.spring.User;
import com.cashbang.configserver.spring.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Service
public class UserRegister1PublisherService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void insert(User user){
        UserRegisterEvent event = new UserRegisterEvent(JSON.toJSONString(user));
        applicationEventPublisher.publishEvent(event);
    }
}
