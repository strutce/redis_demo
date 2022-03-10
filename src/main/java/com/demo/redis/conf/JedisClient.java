package com.demo.redis.conf;

import redis.clients.jedis.JedisPubSub;

public interface JedisClient {

    void subscribe(JedisPubSub jedisPubSub, String channels);

    long publish(String chennal, String message);
}
