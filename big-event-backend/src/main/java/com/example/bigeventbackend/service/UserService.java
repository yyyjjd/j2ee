package com.example.bigeventbackend.service;

import com.example.bigeventbackend.mapper.UserMapper;
import com.example.bigeventbackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 注册
    public void register(User user) {
        userMapper.add(user);
    }

    // 根据用户名查询
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    // 根据ID查询用户信息
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    // 修改信息
    public void update(User user) {
        userMapper.update(user);
    }
}