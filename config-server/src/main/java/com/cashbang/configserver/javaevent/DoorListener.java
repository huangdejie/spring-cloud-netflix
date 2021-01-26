package com.cashbang.configserver.javaevent;

import java.util.EventListener;

/**
 * 所有事件侦听器接口必须扩展EventListener
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public interface DoorListener extends EventListener {

    void doorEvent(DoorEvent doorEvent);

}
