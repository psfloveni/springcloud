package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName： ConfigServerMain3001
 * @Auther: Administrator
 * @Date: 2020/6/9 11:18
 * @return version 1.0
 */

@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain3001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3001.class,args);
    }
}
