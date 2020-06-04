package com.psf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName： OrderFeignHystrixServiceImpl
 * @Auther: Administrator
 * @Date: 2020/6/4 14:18
 * @return version 1.0
 */
@Component
public class PaymentfallbackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK fail....";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut fail....";
    }
}
