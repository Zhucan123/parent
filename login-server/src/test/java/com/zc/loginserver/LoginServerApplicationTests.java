package com.zc.loginserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServerApplicationTests {

    @Test
    public void contextLoads() {
        List<String> strArr = new ArrayList<>();
        String a = "123";
        String b = new String("123");
        String c = b.intern();
        String d = new String("123");
        System.err.println(a == b);
        System.err.println(a == c);
        System.err.println(a == d);
        System.err.println(b == c);
        System.err.println(d == b);
        System.err.println(c == d);
        System.err.println(a.hashCode());
        System.err.println(b.hashCode());
        System.err.println(c.hashCode());
        System.err.println(d.hashCode());

        System.err.println("123" == ("1" + "23"));
    }

}

