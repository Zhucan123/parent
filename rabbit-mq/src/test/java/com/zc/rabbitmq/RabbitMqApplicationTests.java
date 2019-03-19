package com.zc.rabbitmq;

import com.zc.rabbitmq.mqUtil.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.sleep;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTests {

    @Autowired
    private Producer producer;

    private static Thread thread;
    @Test
    public void contextLoads() {
        thread=new Thread(()->{
            //synchronized (producer) {
                for (;;) {
                    producer.sendMsg();
                    System.err.println("发射");
                    try {
                        sleep(1230);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
           // }
        });
        thread.start();
         //System.err.println("start");
    }

}
