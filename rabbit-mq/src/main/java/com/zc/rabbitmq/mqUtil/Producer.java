package com.zc.rabbitmq.mqUtil;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhuCan
 * Project parent.
 * Date 2019/2/18   Time 19:51.
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMsg(){
        String msg="msg"+new Date();
        System.err.println("sent msg: "+msg);
        rabbitTemplate.convertAndSend("hello",msg);

    }
}
