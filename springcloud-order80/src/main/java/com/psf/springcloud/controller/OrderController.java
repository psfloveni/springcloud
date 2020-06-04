package com.psf.springcloud.controller;

import com.psf.springcloud.entity.CommonReslut;
import com.psf.springcloud.entity.Payment;
import com.psf.springcloud.entity.CommonReslut;
import com.psf.springcloud.lb.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName： OrderController
 * @Auther: Administrator
 * @Date: 2020/5/19 14:46
* @return version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    //public static final String url="http://localhost:8001";
    public static final String url = "http://springcloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalanced loadBalanced;


    @GetMapping(value = "/order/payment/insert")
    public CommonReslut<Payment> insert(Payment payment) {
        return restTemplate.postForObject(url + "/payment/insert", payment, CommonReslut.class);
    }

    @GetMapping(value = "/order/payment/getBySerial/{serial}")
    public CommonReslut<Payment> getBySerial(@PathVariable("serial") String serial) {
        return restTemplate.getForObject(url + "/payment/getBySerial/" + serial, CommonReslut.class);
    }

    @GetMapping(value = "/order/payment/getEntity/{serial}")
    public CommonReslut<Payment> getEntity(@PathVariable("serial") String serial) {

        ResponseEntity<CommonReslut> forEntity = restTemplate.getForEntity(url + "/payment/getBySerial/" + serial, CommonReslut.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonReslut(404, "失败");
        }
    }

    @PostMapping(value = "/order/payment/insertEntity")
    public CommonReslut<Payment> insertEntity(Payment payment) {
        CommonReslut body = restTemplate.postForEntity(url + "/payment/insert", payment, CommonReslut.class).getBody();
        return body;
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalanced.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }


}
