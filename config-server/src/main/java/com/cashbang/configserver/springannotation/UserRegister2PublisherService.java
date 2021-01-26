package com.cashbang.configserver.springannotation;

import com.alibaba.fastjson.JSON;
import com.cashbang.configserver.spring.User;
import com.cashbang.configserver.spring.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
@Service
public class UserRegister2PublisherService {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    public void insert(User user){
        UserRegisterEvent event = new UserRegisterEvent(JSON.toJSONString(user));
        applicationEventPublisher.publishEvent(event);
    }
}
