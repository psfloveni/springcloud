package com.psf.springcloud;

import com.psf.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName： OrderMain80
 * @Auther: Administrator
 * @Date: 2020/5/19 14:15
 * @return version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "springcloud-payment-service",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
