package com.psf.springcloud.controller;

import com.psf.springcloud.entity.Payment;
import com.psf.springcloud.entity.CommonReslut;
import com.psf.springcloud.service.OrderService;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName： OrderController
 * @Auther: Administrator
 * @Date: 2020/5/28 14:54
 * @return version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/payment/getBySerial/{serial}")
    public CommonReslut<Payment> getByPaySerial(@PathVariable("serial")String serial){
        return orderService.getByPaySerial(serial);
    }
}
