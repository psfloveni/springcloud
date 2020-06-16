package com.psf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName： OrderController
 * @Auther: Administrator
 * @Date: 2020/5/19 14:46
* @return version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    public static final String url = "http://springcloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;


    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }


}
