package com.cashbang.configserver.javaevent;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class OpenDoorListener implements DoorListener {
    @Override
    public void doorEvent(DoorEvent doorEvent) {
        Integer status = doorEvent.getDoorStatus();
        if(1 == status){
            System.out.println("the door is open");
        }
    }
}
