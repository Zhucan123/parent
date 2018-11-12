package com.zc.serverribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    public String sayHello(String name){

        return restTemplate.getForObject("http://service-hi/hi?name=zc"+name,String.class);
    }

    public String sayHelloFallback(String name){
        return "ribbon fallback error"+name;
    }
}
