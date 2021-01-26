package com.cashbang.configserver.jdobserver;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public interface Consumer {

    void update(String message);

}
