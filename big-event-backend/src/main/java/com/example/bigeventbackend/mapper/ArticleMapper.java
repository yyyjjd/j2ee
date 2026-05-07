package com.example.bigeventbackend.mapper;

import com.example.bigeventbackend.pojo.Article;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ArticleMapper {

    // 新增文章
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, now(), now())")
    void add(Article article);

    // 查询所有文章
    @Select("select * from article")
    List<Article> list();

    // 删除文章
    @Delete("delete from article where id=#{id}")
    void delete(Integer id);

    // 修改文章
    @Update("update article set title=#{title}, content=#{content}, cover_img=#{coverImg}, " +
            "state=#{state}, category_id=#{categoryId}, update_time=now() where id=#{id}")
    void update(Article article);
}