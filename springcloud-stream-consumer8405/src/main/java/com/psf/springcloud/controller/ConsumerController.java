package com.psf.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.psf.springcloud.entity.User;
import com.psf.springcloud.service.MySink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName： Consumer
 * @Auther: Administrator
 * @Date: 2020/6/12 12:39
 * @return version 1.0
 */
@EnableBinding({MySink.class})
@Component
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 接收对象
     * @param
     */
    @StreamListener(MySink.User_INPUT)
    @SendTo(MySink.LOG_userOutput8405)
    public String sendUser(User user) {
        System.out.println(serverPort+"号INPUT1  "+user);
        User newUser = new User();
        newUser.setId(55);
        newUser.setName(user.getName());
        return  "接收到"+serverPort+"的数据"+newUser;
    }

    @StreamListener(MySink.SCORE_INPUT)
    public void SCORE_INPUT(Message<String> message) {
        System.out.println(serverPort+"号SCORE_INPUT："+message.getPayload());
    }


}
