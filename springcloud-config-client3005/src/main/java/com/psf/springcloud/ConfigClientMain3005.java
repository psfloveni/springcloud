package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName： ConfigClientMain3005
 * @Auther: Administrator
 * @Date: 2020/6/9 14:07
 * @return version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3005 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3005.class,args);
    }
}
