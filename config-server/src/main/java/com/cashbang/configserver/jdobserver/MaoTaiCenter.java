package com.cashbang.configserver.jdobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class MaoTaiCenter implements WineCenter {

    private List<Consumer> list = new ArrayList<>();


    @Override
    public void registerConsumer(Consumer consumer) {
        list.add(consumer);
    }

    @Override
    public void removeConsumer(Consumer consumer) {
        list.remove(consumer);
    }

    @Override
    public void notify(String message) {
        System.out.println("茅台发布了："+message);
        System.out.println("------------------");
        for (Consumer consumer : list) {
            consumer.update(message);
        }
    }
}
