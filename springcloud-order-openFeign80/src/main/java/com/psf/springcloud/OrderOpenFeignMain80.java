package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName： OrderOpenFeignMain80
 * @Auther: Administrator
 * @Date: 2020/5/28 14:52
 * @return version 1.0
 */
@SpringBootApplication
@EnableFeignClients //开启openFeign
public class OrderOpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain80.class,args);
    }
}
