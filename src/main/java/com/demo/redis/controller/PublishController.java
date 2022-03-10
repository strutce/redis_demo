package com.demo.redis.controller;

import com.demo.redis.constants.RedisConstants;
import com.demo.redis.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: zengyz
 * @Date: 2022/3/10 14:28
 */
@RestController
@RequestMapping("/pub")
public class PublishController {

    @Autowired
    private PublishService publishService;

    @RequestMapping(value = "/sendmessage")
    public void sendmessage(String message) {
        publishService.sendmessage(message);
    }



}
