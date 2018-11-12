package com.zc.feign.controller;

import com.zc.feign.rpcService.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping("/hi")
    public String sayHello(@RequestParam(value = "name")String name){
        return "feign,"+schedualServiceHi.sayHello(name);
    }
}
