package com.psf.springcloud.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {


    String User_INPUT = "myUserInput";
    @Input(MySink.User_INPUT)
    SubscribableChannel userInput();

    /**
     * 接收后转发
     */
    String LOG_userOutput8406 = "logUserOutput8406";
    @Output(MySink.LOG_userOutput8406)
    MessageChannel logUserOutput8406();


    String SCORE_INPUT = "mqScoreInput";

    @Input(MySink.SCORE_INPUT)
    SubscribableChannel scoreInput();
}
