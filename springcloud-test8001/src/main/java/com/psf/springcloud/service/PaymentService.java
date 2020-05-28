package com.psf.springcloud.service;

import com.psf.springcloud.entity.Payment;

/**
 * @ClassName： PaymentService
 * @Auther: Administrator
 * @Date: 2020/5/19 08:58
 * @return version 1.0
 */
public interface PaymentService {

    public int insert(Payment payment);

    public Payment getByPaySerial(String serial);
}
