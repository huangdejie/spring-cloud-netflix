package com.cashbang.configserver.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
@Component
public class HelloWorld {

    @Value("${message:信息}")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
