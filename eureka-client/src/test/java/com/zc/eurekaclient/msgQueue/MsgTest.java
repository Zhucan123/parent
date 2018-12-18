package com.zc.eurekaclient.msgQueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuCan on 2018/12/18.
 * Project parent.
 * Date 2018/12/18   Time 10:07.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MsgTest {

    @Autowired
    CountDownLatch latch;
    @Autowired
    StringRedisTemplate template;

    @Test
    public void test(){
        System.out.println("我要发送消息咯...");
        template.convertAndSend("msg", "欢迎使用redis的消息队列!");
        try {
            //发送消息连接等待中
            System.out.println("消息正在发送...");
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("消息发送失败...");
        }

    }
}
