package com.zc.eurekaclient.secondaryDomainTest;

import com.zc.eurekaclient.secondaryDomain.CraftEntity;
import com.zc.eurekaclient.secondaryDomain.CraftRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhuCan on 2018/12/3.
 * Project parent.
 * Date 2018/12/3   Time 16:55.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondaryTest {
    @Autowired
    private CraftRepository craftRepository;

    @Test
    public void test(){
        List<CraftEntity> craftEntities=craftRepository.findAll();
        System.err.println("123");
    }
}
