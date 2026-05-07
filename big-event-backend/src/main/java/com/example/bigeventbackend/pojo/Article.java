package com.example.bigeventbackend.pojo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String coverImg; // 对应表中的 cover_img
    private String state;    // 对应表中的 state（你表里是state，不是status！）
    private Integer categoryId; // 对应表中的 category_id
    private Integer createUser; // 对应表中的 create_user
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}