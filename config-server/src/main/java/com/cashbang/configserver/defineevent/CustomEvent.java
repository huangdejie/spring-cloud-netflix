package com.cashbang.configserver.defineevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
//@Component
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "My Custom Event";
    }
}
