package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName： StreamConsumerMain8405
 * @Auther: Administrator
 * @Date: 2020/6/11 17:23
 * @return version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerSleuthMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerSleuthMain80.class,args);
    }
}
