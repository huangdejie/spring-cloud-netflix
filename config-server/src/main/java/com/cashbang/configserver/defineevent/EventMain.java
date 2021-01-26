package com.cashbang.configserver.defineevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class EventMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cashbang.configserver.defineevent");
        context.start();
        CustomEvent customEvent = context.getBean(CustomEvent.class);
        System.out.println(context.toString()+"*****");
        CustomEventPublisher cvp = context.getBean(CustomEventPublisher.class);
        cvp.publish();
        cvp.publish();
    }

}
