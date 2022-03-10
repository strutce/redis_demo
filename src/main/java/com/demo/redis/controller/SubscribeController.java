package com.demo.redis.controller;

import com.demo.redis.vo.SubscribeVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zengyz
 * @Date: 2022/3/10 14:28
 */
@RestController
@RequestMapping("/sub")
public class SubscribeController {

    @RequestMapping(value = "/receiveMessage")
    @ResponseBody
    public List<String> receiveMessage() {
        System.out.println("接收消息："+SubscribeVo.messagelist);
        return SubscribeVo.messagelist;
    }
}
