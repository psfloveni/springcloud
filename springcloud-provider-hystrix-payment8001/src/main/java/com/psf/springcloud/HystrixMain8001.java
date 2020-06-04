package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName： HystrixMain8001
 * @Auther: Administrator
 * @Date: 2020/6/1 15:10
 * @return version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker // 开启HystrixCommand 注解
public class HystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class,args);
    }

}
