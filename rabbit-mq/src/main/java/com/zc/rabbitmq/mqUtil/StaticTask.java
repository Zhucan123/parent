package com.zc.rabbitmq.mqUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

/**
 * Created by zhuCan on 2018/12/17.
 * Project parent.
 * Date 2018/12/17   Time 8:41.
 *
 * 基于注解版的定时任务
 * 简单 方便, 但是如果修改时间要重启项目,静态型的
 */
@Configuration
@EnableScheduling
public class StaticTask {
  /*  @Autowired
    private RedisUtil redisUtil;*/
    @Autowired
    private Producer producer;

    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

    private final static String TIMER_MAP="timeMap";
    private final static String TIMER_INDEX="time_index";

    /**
     * @author zhuCan
     * @date 2018-12-17 10:16
     * @description : cron表达式设置时间间隔,定时向缓存里面存值
    */
    @Scheduled(cron = "* * * * * ?")
    private void pushToCache(){
        producer.sendMsg();
    }

}
