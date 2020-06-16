package com.psf.springcloud.service.impl;

import com.psf.springcloud.entity.User;
import com.psf.springcloud.service.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName： MessageProviderService
 * @Auther: Administrator
 * @Date: 2020/6/11 16:49
 * @return version 1.0
 */

@EnableBinding({MySource.class})
@Service
public class Providers  {

    @Resource
    private MySource mySource;

    /**
     * 对象
     * @return
     */

    public void sendUser() {
        User user = new User();
        user.setId(2);
        user.setName("zhangsan");
        mySource.output1().send(MessageBuilder.withPayload(user).build());
        System.out.println("发送消息sendUser");
    }

    public void send1() {
        Message<String> fffff = MessageBuilder.withPayload("fffffsend1").build();
        mySource.scoreOutput().send(fffff);
        System.out.println("发送消息send1");
    }

}
