package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName： ConfigClientMain3306
 * @Auther: Administrator
 * @Date: 2020/6/10 10:49
 * @return version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3006 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3006.class,args);
    }
}
