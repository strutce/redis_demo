package com.demo.redis.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

@Service
public class JedisClientSingle implements JedisClient {


    @Autowired
    private JedisPool jedisPool;

    /**
     * 订阅消息
     *
     * @param jedisPubSub
     * @param channels
     */
    public void subscribe(JedisPubSub jedisPubSub, String channels) {
        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(jedisPubSub, channels);
        jedis.close();
    }

    /**
     * 发送消息
     *
     * @param chennal
     * @param message
     * @return
     */
    public long publish(String chennal, String message) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.publish(chennal, message);
        return result;
    }
}
