package com.demo.redis.entity;

import java.util.List;

public interface UserEntityMapper {
    int insert(UserEntity record);

    List<UserEntity> selectAll();
}