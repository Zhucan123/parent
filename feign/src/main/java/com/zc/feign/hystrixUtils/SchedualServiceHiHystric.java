package com.zc.feign.hystrixUtils;

import com.zc.feign.rpcService.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHello(String name) {
        return "fallback"+name;
    }
}
