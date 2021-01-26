package com.cashbang.configserver.javaevent;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class CloseDoorListener implements DoorListener {
    @Override
    public void doorEvent(DoorEvent doorEvent) {
        Integer openStatus = doorEvent.getDoorStatus();
        if(0 == openStatus){
            System.out.println("the door is close");
        }
    }
}
