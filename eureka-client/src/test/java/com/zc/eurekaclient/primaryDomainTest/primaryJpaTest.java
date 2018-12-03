package com.zc.eurekaclient.primaryDomainTest;

import com.zc.eurekaclient.primaryDomain.V_Video;
import com.zc.eurekaclient.primaryDomain.VideoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhuCan on 2018/12/3.
 * Project parent.
 * Date 2018/12/3   Time 16:21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class primaryJpaTest {
    @Autowired
    private VideoRepository videoRepository;

    @Value("${spring.application.name}")
    private String name;

   @Test
    public void test(){
        List<V_Video> videos=videoRepository.findAll();
        System.err.println(name);
    }
}
