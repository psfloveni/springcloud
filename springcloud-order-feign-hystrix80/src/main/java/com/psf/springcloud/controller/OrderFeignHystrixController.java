package com.psf.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.psf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName： OrderController
 * @Auther: Administrator
 * @Date: 2020/6/2 10:18
 * @return version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfoFallbackMethodNoGlobal")  //超时 异常 走全局
public class OrderFeignHystrixController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/order/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result=paymentService.paymentInfo_OK(id);
        return "80:"+result;
    }

    @GetMapping(value = "/order/payment/timeOut/{id}")
   @HystrixCommand(fallbackMethod = "paymentInfoFallbackMethodNo",commandProperties = {
           @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
   }) //指明的
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result=paymentService.paymentInfo_TimeOut(id);
        return "80:"+result;
    }

    public String paymentInfoFallbackMethodNo(@PathVariable("id") Integer id) {
        return "80：系统异常，请重试"+id;
    }

    @HystrixCommand //无特别指明 全局的
    @GetMapping(value = "/order/payment/Global/{id}")
    public String paymentInfo_NoGlobal(@PathVariable("id") Integer id) {
        String result=paymentService.paymentInfo_TimeOut(id);
        return "80:"+result;
    }

    //下面是全局fallback方法
    public String paymentInfoFallbackMethodNoGlobal(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }

}
