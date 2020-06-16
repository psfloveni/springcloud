package com.psf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName： ClientController
 * @Auther: Administrator
 * @Date: 2020/6/9 14:10
 * @return version 1.0
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Value("${config.version}")
    private String port;

    @GetMapping("/getProperties")
    public String GetProperties(){
        return this.name+"  \t"+this.age+"\t"+port;
    }
}
