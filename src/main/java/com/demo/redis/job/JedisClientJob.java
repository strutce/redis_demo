package com.demo.redis.job;

import com.demo.redis.conf.JedisClientSingle;
import com.demo.redis.constants.RedisConstants;
import com.demo.redis.vo.SubscribeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: zengyz
 * @Date: 2022/3/10 14:47
 */
@Component
public class JedisClientJob {
    @Autowired
    private JedisClientSingle jedisClientSingle;
    @PostConstruct
    public void action() {
        //启动一个线程去获取数据
        new Thread(new Runnable() {
            public void run() {
                try {
                    SubscribeVo subscribeVo=new SubscribeVo();
                    jedisClientSingle.subscribe(subscribeVo, RedisConstants.CHANNEL_NAME);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
