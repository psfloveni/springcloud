package com.psf.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @ClassName： orderService
 * @Auther: Administrator
 * @Date: 2020/6/2 10:14
 * @return version 1.0
 */
@Component
@FeignClient(value ="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentfallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) ;

    @GetMapping(value = "/payment/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id) ;
}
