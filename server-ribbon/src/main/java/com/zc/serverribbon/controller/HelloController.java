package com.zc.serverribbon.controller;

import com.zc.serverribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hello(@RequestParam String name){
        return "ribbon+rest,"+helloService.sayHello(name);
    }
}
