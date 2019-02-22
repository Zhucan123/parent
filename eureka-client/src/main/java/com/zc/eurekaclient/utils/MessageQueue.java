package com.zc.eurekaclient.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by zhuCan on 2018/12/17.
 * Project parent.
 * Date 2018/12/17   Time 17:02.
 */

@Component
public class MessageQueue extends Thread {
    @Autowired
    private volatile RedisUtil redisUtil;

    private final static String TEST_MESSAGE_QUEUE = "test_message_queue";

    private volatile Object lock = new Object();

    @Override
    public void run() {
        synchronized (redisUtil) {
            while (true) {
                try {

                    if (redisUtil.queueIsEmpty(TEST_MESSAGE_QUEUE)) {
                        redisUtil.wait();
                    }
                    Object res = redisUtil.getMessage(TEST_MESSAGE_QUEUE);
                    System.err.println(res.toString());


                    //sleep(1500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean putMsg(String msg) {
        boolean res = redisUtil.putMessage(TEST_MESSAGE_QUEUE, msg);
        if (res) {
            synchronized (redisUtil) {
                redisUtil.notifyAll();

            }


        }
        return res;

    }
}
