package com.cashbang.configserver.javaevent;

import java.util.EventObject;

/**
 * 开/关门事件
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class DoorEvent extends EventObject {

    private Integer doorStatus;

    public DoorEvent(Object source) {
        super(source);
    }

    public DoorEvent(Object source, Integer doorStatus) {
        super(source);
        this.doorStatus = doorStatus;
    }

    public Integer getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(Integer doorStatus) {
        this.doorStatus = doorStatus;
    }
}
