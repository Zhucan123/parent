package com.zc.eurekaclient.redis;

import com.zc.eurekaclient.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuCan on 2018/12/14.
 * Project parent.
 * Date 2018/12/14   Time 14:23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void test(){
        redisUtil.hSet("task_map","task_cron_test","0 */8 * * * ?");


        redisUtil.set("书","日本語の本");
        redisUtil.set("树","木下　は　赤い　紅葉　が　あいます",100L);
        Map<String,Object> map=new HashMap<>();
        map.put("wife","zl");
        map.put("boy","zc");
        redisUtil.hMSet("people",map);
        System.err.println(redisUtil.get("书"));
        System.err.println(redisUtil.get("树"));
        long res=redisUtil.sequence("index2");
        Object o1=redisUtil.get("index1");
        System.err.println(redisUtil.hMGet("people").get("boy"));
    }


}
