package com.zc.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Created by zhuCan
 * Project parent.
 * Date 2019/2/18   Time 19:48.
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
