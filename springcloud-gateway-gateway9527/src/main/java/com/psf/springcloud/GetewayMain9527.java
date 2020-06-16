package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName： GetewayMain9527
 * @Auther: Administrator
 * @Date: 2020/6/8 14:14
 * @return version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GetewayMain9527 {


    public static void main(String[] args) {
        SpringApplication.run(GetewayMain9527.class,args);
    }
}
