package com.psf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName： HystrixDashboardMain9001
 * @Auther: Administrator
 * @Date: 2020/6/5 10:12
 * @return version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard //服务监控
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
