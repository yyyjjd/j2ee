package com.example.bigeventbackend.mapper;

import com.example.bigeventbackend.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Insert("insert into user(username, password, create_time, update_time) " +
            "values(#{username}, #{password}, #{createTime}, #{updateTime})")
    void add(User user);
}