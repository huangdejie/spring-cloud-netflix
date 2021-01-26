package com.cashbang.configserver.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Service
public class UserRegisterPublisherService implements ApplicationEventPublisherAware {

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
