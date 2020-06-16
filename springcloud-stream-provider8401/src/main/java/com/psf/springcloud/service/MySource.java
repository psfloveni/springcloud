package com.psf.springcloud.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @ClassName： MyInputService
 * @Auther: Administrator
 * @Date: 2020/6/12 11:32
 * @return version 1.0
 */
public interface MySource{

    String OUTPUT1 = "userOutput";
    @Output(MySource.OUTPUT1)
    MessageChannel output1();

    //回传 8405
    String LOG_userInput8405 = "logUserInput8405";
    @Input(MySource.LOG_userInput8405)
    SubscribableChannel logUserInput8405();

    //回传 8406
    String LOG_userInput8406 = "logUserInput8406";
    @Input(MySource.LOG_userInput8406)
    SubscribableChannel logUserInput8406();

    String SCORE_OUPUT = "mqScoreOutput";
    @Output(MySource.SCORE_OUPUT)
    MessageChannel scoreOutput();
}
