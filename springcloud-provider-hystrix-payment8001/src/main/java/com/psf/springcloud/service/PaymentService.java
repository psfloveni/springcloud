package com.psf.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName： PaymentService
 * @Auther: Administrator
 * @Date: 2020/6/1 15:23
 * @return version 1.0
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_fallbackMethod_TimeOut",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        /*int timeNumber = 1;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return "成功进8001";
    }

    public String paymentInfo_fallbackMethod_TimeOut(Integer id) {
        return "8001系统错误";
    }
    }
