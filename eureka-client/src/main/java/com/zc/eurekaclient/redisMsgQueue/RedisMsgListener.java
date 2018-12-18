package com.zc.eurekaclient.redisMsgQueue;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuCan on 2018/12/18.
 * Project parent.
 * Date 2018/12/18   Time 9:18.
 */
public class RedisMsgListener {

    private CountDownLatch latch;

    @Autowired
    public RedisMsgListener(CountDownLatch latch){

        this.latch=latch;
    }

    public void  receiveMsg(String msg){
        System.err.println("Received msg:===> "+msg);
        latch.countDown();
    }
}
