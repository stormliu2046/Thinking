package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void batchInsert() {
        List<User> users = new LinkedList<>();
        users.add(User.builder()
                .name("ljh")
                .age(23)
                .email("18179465177@163.com")
                .build());
        userRepository.saveBatch(users);
    }

    @Override
    public void insert() {
        int row = userRepository.getBaseMapper().insert(User.builder()
                .name("ljh")
                .age(23)
                .email("18179465177@163.com")
                .build());
        System.out.println(row);
    }
}
