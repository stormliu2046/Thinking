package com.example.demo.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author robert
 */
@Service
public class UserRepository extends ServiceImpl<UserMapper, User> {
}
