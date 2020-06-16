package com.psf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName： PaymentController
 * @Auther: Administrator
 * @Date: 2020/5/19 09:18
 * @return version 1.0
 */

@RestController
@Slf4j
public class PaymentController {


    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "测试zipkin";
    }
}
