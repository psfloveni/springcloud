package com.psf.springcloud.service;

import com.psf.springcloud.entity.Payment;
import com.psf.springcloud.entity.CommonReslut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName： OrderService
 * @Auther: Administrator
 * @Date: 2020/5/28 14:55
 * @return version 1.0
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PAYMENT-SERVICE") //使用feign
public interface OrderService {

    @GetMapping(value = "/payment/getBySerial/{serial}")
    public CommonReslut<Payment> getByPaySerial(@PathVariable("serial")String serial);
}
