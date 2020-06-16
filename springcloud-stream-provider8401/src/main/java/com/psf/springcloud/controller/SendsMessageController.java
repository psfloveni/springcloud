package com.psf.springcloud.controller;

import com.psf.springcloud.service.MySource;
import com.psf.springcloud.service.impl.Providers;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName： MessageController
 * @Auther: Administrator
 * @Date: 2020/6/11 16:59
 * @return version 1.0
 */
@RestController
public class SendsMessageController {
    @Resource
    private Providers providers;

    @Resource
    private MySource mySource;


    @GetMapping(value = "/sendUser")
    public void sendMessage1() {

         providers.sendUser();
    }

    @GetMapping(value = "/sendServer")
    public void SendServer() {
        providers.send1();
    }

    /**
     * 接收
     */
 @StreamListener(MySource.LOG_userInput8405)
    public void SendServer8405(Message<String> message){
     System.out.println("接收成功："+message.getPayload());
    }

    /**
     * 接收
     */
 @StreamListener(MySource.LOG_userInput8406)
    public void SendServer8406(Message<String> message){
     System.out.println("接收成功："+message.getPayload());
    }


}

