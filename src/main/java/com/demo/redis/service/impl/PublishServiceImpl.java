package com.demo.redis.service.impl;

import com.demo.redis.constants.RedisConstants;
import com.demo.redis.entity.MessageEntity;
import com.demo.redis.entity.MessageEntityMapper;
import com.demo.redis.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: zengyz
 * @Date: 2022/3/10 15:54
 */
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    private MessageEntityMapper messageEntityMapper;

    public void sendmessage(String message) {
        publish(message);
        sort(message);
        save(message);
    }

    private void publish(String message){
        //这里使用spring整合的jedisPool，使用一会就不能使用了。
        //先这样写吧
        JedisPool jedisPool = new JedisPool("192.168.86.157",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.publish(RedisConstants.CHANNEL_NAME,message);
        jedis.close();
        jedisPool.close();
    }

    private void sort(String message){
        MessageEntity messageEntity=new MessageEntity();
        messageEntity.setMessage(message);
        messageEntityMapper.insert(messageEntity);
    }

    private void save(String message){

    }
}
