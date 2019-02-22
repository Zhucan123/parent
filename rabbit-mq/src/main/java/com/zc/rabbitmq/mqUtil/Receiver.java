package com.zc.rabbitmq.mqUtil;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuCan
 * Project parent.
 * Date 2019/2/18   Time 19:55.
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void receiveMsg(String msg){

        System.err.println("receiver :"+msg);
    }
}
