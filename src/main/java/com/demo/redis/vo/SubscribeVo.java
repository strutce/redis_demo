package com.demo.redis.vo;

import lombok.Data;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zengyz
 * @Date: 2022/3/10 14:38
 */
@Data
public class SubscribeVo extends JedisPubSub {
    private String name;
    private String room;
    public static List<String> messagelist = new ArrayList<String>();

    @Override
    public void onMessage(String channel, String message) {
        messagelist.add(message);
    }
}
