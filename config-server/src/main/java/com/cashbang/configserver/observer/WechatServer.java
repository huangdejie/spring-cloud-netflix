package com.cashbang.configserver.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者（微信公众号服务）
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class WechatServer implements Observerable {

    private List<Observer> list;

    private String message;

    public WechatServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!list.isEmpty()){
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.update(message);
        }
    }

    public void setInformation(String s){
        this.message = s;
        System.out.println("************微信服务更新消息:"+s);
        notifyObserver();
    }
}
