package com.psf.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName： applicationRestTemplate
 * @Auther: Administrator
 * @Date: 2020/5/19 14:42
 * @return version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced  //赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
