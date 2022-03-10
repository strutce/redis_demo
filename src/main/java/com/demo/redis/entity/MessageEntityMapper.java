package com.demo.redis.entity;

import java.util.List;

public interface MessageEntityMapper {
    int insert(MessageEntity record);

    List<MessageEntity> selectAll();
}