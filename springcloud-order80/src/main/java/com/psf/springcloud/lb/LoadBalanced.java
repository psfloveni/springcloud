package com.psf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName： LoadBalanced
 * @Auther: Administrator
 * @Date: 2020/5/27 15:06
 * @return version 1.0
 */


public interface LoadBalanced {

    public ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
