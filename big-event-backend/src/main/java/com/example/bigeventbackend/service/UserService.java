package com.example.bigeventbackend.service;

import com.example.bigeventbackend.pojo.Result;

public interface UserService {
    Result register(String username, String password);
    Result login(String username, String password);
}