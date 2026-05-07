package com.example.bigeventbackend.mapper;

import com.example.bigeventbackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user(username,password,create_time,update_time) values(#{username},#{password},now(),now())")
    void add(User user);

    @Update("update user set nickname=#{nickname},email=#{email},update_time=now() where id=#{id}")
    void update(User user);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);
}