package com.psf.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName： myRule
 * @Auther: Administrator
 * @Date: 2020/5/27 10:31
 * @return version 1.0
 */

@Configuration
public class MySelfRule  {

    @Bean
    public IRule myRule(){
        return new RandomRule();//设置随机
    }
}
