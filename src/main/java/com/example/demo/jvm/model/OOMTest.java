package com.example.demo.jvm.model;

import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author robert
 * @date 2021/2/26
 */
public class OOMTest {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
