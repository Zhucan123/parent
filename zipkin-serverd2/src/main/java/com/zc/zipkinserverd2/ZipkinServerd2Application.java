package com.zc.zipkinserverd2;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootApplication
@RestController
public class ZipkinServerd2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerd2Application.class, args);
    }

    private static final Logger log= Logger.getLogger(ZipkinServerd2Application.class.getName());

    @RequestMapping("/hi")
    public String home(){
        log.log(Level.INFO,"HI");
        return "this is miy";
    }

    @RequestMapping("/miya")
    public String info(){
        log.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }


}
