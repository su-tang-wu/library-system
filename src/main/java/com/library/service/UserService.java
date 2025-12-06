package com.library.service;

import com.library.entity.User;
import com.library.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }

    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }
}
