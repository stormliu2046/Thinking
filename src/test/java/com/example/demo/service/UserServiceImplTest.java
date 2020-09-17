package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author robert
 */
@SpringBootTest
class UserServiceImplTest {

    @Resource
    UserService userService;

    @Test
    void batchInsert() {
        userService.batchInsert();
    }
}