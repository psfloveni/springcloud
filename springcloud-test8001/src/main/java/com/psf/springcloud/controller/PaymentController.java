package com.psf.springcloud.controller;

import com.psf.springcloud.entity.Payment;
import com.psf.springcloud.entity.CommonReslut;
import com.psf.springcloud.service.impl.PaymentImplService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName： PaymentController
 * @Auther: Administrator
 * @Date: 2020/5/19 09:18
 * @return version 1.0
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentImplService paymentImplService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/insert")
    public CommonReslut insert(@RequestBody Payment payment){

        int insert = paymentImplService.insert(payment);
        if (insert>0){
            return new CommonReslut(200,"添加成功,端口="+serverPort,insert);
        }
        else {
            return new CommonReslut(404,"添加失败",insert);
        }
    }

    @GetMapping(value = "/payment/getBySerial/{serial}")
    public CommonReslut getBySerial(@PathVariable("serial") String serial){

        Payment payment = paymentImplService.getByPaySerial(serial);
        if (payment!= null){
            return new CommonReslut(200,"查询成功,端口="+serverPort,payment);
        }
        else {
            return new CommonReslut(404,"查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        //在注册中心获取app-producer对应的服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "测试zipkin";
    }
}
