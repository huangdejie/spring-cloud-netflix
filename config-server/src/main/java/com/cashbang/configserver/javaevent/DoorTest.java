package com.cashbang.configserver.javaevent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangdj
 * @Date: 2021/1/13
 */
public class DoorTest {

    public static List<DoorListener> getAllDoorListener(){
        List<DoorListener> list = new ArrayList<>();
        DoorListener door1 = new CloseDoorListener();
        DoorListener door2 = new OpenDoorListener();
        list.add(door1);
        list.add(door2);
        return list;
    }

    public static void main(String[] args) {
        DoorEvent doorEvent = new DoorEvent("open",1);
        List<DoorListener> listeners = getAllDoorListener();
        for (DoorListener listener : listeners) {
            listener.doorEvent(doorEvent);
        }
    }

}
