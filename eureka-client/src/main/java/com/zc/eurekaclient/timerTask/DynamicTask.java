package com.zc.eurekaclient.timerTask;

import com.zc.eurekaclient.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuCan on 2018/12/17.
 * Project parent.
 * Date 2018/12/17   Time 11:34.
 *
 * 动态定时器,cron表达式可以在数据库读取,自行设置,目前先在redis里面取
 */
@Configuration
@EnableScheduling
public class DynamicTask implements SchedulingConfigurer {
    @Autowired
    private RedisUtil redisUtil;

    private final static String DYNAMIC_INDEX="dynamic_index";
    private final static String TASK_MAP="task_map";
    private final static String DYNAMIC_TIMER_MAP="dynamic_timer_map";
    private final static String TASK_CRON_TEST="task_cron_test";
    //默认的 cron
    private final static String SIMPLE_CRON="0 */5 * * * ?";

    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
         taskRegistrar.addTriggerTask(()->{
             //业务代码

             Object index=redisUtil.sequence(DYNAMIC_INDEX);
             redisUtil.hSet(DYNAMIC_TIMER_MAP,index
                     .toString(),dateFormat.format(new Date()),3600*48);
             System.err.println(redisUtil.hGet(DYNAMIC_TIMER_MAP,index.toString()));


         },triggerContext -> {
             //设置定时器的时间间隔
             Object cron=redisUtil.hGet(TASK_MAP,TASK_CRON_TEST);
             if (cron==null){
                 //如果没查到就返回个默认的cron
                  cron= SIMPLE_CRON;
             }
             return new CronTrigger(cron.toString()).nextExecutionTime(triggerContext);
         });
    }
}
