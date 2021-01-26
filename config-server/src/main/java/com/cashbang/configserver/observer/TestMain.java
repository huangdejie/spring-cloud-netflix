package com.cashbang.configserver.observer;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class TestMain {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);

        server.setInformation("PHP是世界上最好用的语言！");

        System.out.println("-------------------");
        server.removeObserver(userZhang);
        server.setInformation("Java是世界上最好的语言！");
    }

}
