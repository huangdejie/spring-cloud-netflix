package com.cashbang.orderserviceprovider;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: huangdj
 * @Date: 2021/1/21
 */
@SpringBootTest
public class CopyOnWriteArrayListTest {

    @Test
    public void test(){
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("nihao");
        list.add("world");
        list.add(0,"haha");
        list.add("hello");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
