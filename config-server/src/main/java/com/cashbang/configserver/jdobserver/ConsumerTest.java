package com.cashbang.configserver.jdobserver;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer consumer = new JdConsumer("王武");
        Consumer consumer1 = new JdConsumer("赵四");
        Consumer consumer2 = new JdConsumer("歇歇");
        WineCenter wineCenter = new MaoTaiCenter();
        wineCenter.registerConsumer(consumer);
        wineCenter.registerConsumer(consumer2);
        wineCenter.registerConsumer(consumer2);
        wineCenter.notify("明日将发售60瓶飞天茅台，敬请期待！");
    }


}
