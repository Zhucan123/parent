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
    @Test
    public void contextLoads() {
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run(){
                while (true){
                    producer.sendMsg();
                    try {
                        sleep(1230);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
    }

}
