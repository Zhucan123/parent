package com.zc.eurekaclient.redisMsgQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuCan on 2018/12/18.
 * Project parent.
 * Date 2018/12/18   Time 9:15.
 */
@Configuration
public class RedisProducer {
    @Bean
    RedisMsgListener redisMsgListener(CountDownLatch latch){
        return new RedisMsgListener(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }
        @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListener messageListener){
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListener,new PatternTopic("msg"));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RedisMsgListener redisMsgListener){
        return  new MessageListenerAdapter(redisMsgListener,"receiveMsg");
    }
}

