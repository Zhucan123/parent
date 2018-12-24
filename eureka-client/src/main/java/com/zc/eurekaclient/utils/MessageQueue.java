package com.zc.eurekaclient.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuCan on 2018/12/17.
 * Project parent.
 * Date 2018/12/17   Time 17:02.
 */

@Configuration
public class MessageQueue extends Thread{
    @Autowired
    private RedisUtil redisUtil;

    private final static String TEST_MESSAGE_QUEUE="test_message_queue";

    @Override
    public void run(){
       while (true){
           try {
               synchronized (MessageQueue.class) {
                   if (redisUtil.queueIsEmpty(TEST_MESSAGE_QUEUE)) {
                       wait();
                   }
                   Object res=redisUtil.getMessage(TEST_MESSAGE_QUEUE);
                   System.err.println(res.toString());
               }

               sleep(500);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }

    public boolean putMsg(String msg){
        boolean res=redisUtil.putMessage(TEST_MESSAGE_QUEUE,msg);
        if (res){

           // MessageQueue.class.notify();

        }
        return res;

    }
}
