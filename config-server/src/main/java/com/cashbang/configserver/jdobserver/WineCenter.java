package com.cashbang.configserver.jdobserver;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public interface WineCenter {

    void registerConsumer(Consumer consumer);

    void removeConsumer(Consumer consumer);

    void notify(String message);

}
