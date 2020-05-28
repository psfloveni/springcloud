package com.psf.springcloud.lb.impl;

import com.psf.springcloud.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName： loadBalancedImpl
 * @Auther: Administrator
 * @Date: 2020/5/27 15:16
 * @return version 1.0
 */
@Component
public class loadBalancedImpl implements LoadBalanced {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Resource
    private DiscoveryClient discoveryClient;

    //负载均衡算法：rest第几次请求书/服务器集群的总数=实际调用服务器位置的下标，
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {  //得到机器的列表
        int index = getAndIncrement() % serviceInstances.size(); //得到服务器的下标位置
        return serviceInstances.get(index);
    }


    //坐标
    private final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));  //第一个参数是期望值，第二个参数是修改值是
        System.out.println("*******第几次访问，次数next: "+next);
        return next;
    }

}
