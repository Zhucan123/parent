package com.zc.eurekaclient.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuCan on 2018/12/14.
 * Project parent.
 * Date 2018/12/14   Time 13:50.
 */
@Component
public class RedisUtil {
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    //批量删除
    public void remove(final String... keys){
        for (String key:keys){
            remove(key);
        }
    }

    //批量删键
    public void removePattern(final String pattern){
        Set<Serializable> keys=template.keys(pattern);
        if (keys.size()>0){
            template.delete(keys);
        }
    }

    //单删
    public void remove(final String key){
        if (exists(key)){
            template.delete(key);
        }
    }

    //判断是否有值
    public boolean exists(final String key){
        return template.hasKey(key);
    }

    //读取
    public String get(final String key){
        Object res=null;
        template.setValueSerializer(new StringRedisSerializer());
        ValueOperations<Serializable,Object> operations=template.opsForValue();
        res=operations.get(key);
        return res==null?null:res.toString();
    }

    //写值
    public boolean set(final String key,Object value){
        boolean flag=false;
        try{
            ValueOperations<Serializable ,Object>operations=template.opsForValue();
            operations.set(key,value);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //定时过期的写值
    public boolean set(final  String key,Object val,Long time){
        boolean flag=false;
        try{
            ValueOperations<Serializable,Object>operations=template.opsForValue();
            operations.set(key,val);
            template.expire(key,time,TimeUnit.SECONDS);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //写入hashmap
    public boolean hashSet(String key, Map<String,String> value){
        boolean flag=false;
        try{
            template.opsForHash().putAll(key,value);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //获值hash
    public Map<String,String>hmGet(String key){
        Map<String,String> res=null;
        try {
            res=template.opsForHash().entries(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  res;
    }
}
