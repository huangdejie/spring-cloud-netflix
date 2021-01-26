package com.cashbang.configserver.jdobserver;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class JdConsumer implements Consumer{

    private String name;

    public JdConsumer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name+"收到了:"+message);
    }
}
