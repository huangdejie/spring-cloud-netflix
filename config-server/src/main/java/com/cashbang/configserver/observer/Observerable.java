package com.cashbang.configserver.observer;

/**
 * 抽象被观察者接口
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public interface Observerable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

}
