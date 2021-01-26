package com.cashbang.configserver.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: huangdj
 * @Date: 2021/1/14
 */
public class UserRegisterEvent extends ApplicationEvent {
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
