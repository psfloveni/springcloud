package com.psf.springcloud.service.impl;

import com.psf.springcloud.dao.PaymentDao;
import com.psf.springcloud.entity.Payment;
import com.psf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName： PayMentImplService
 * @Auther: Administrator
 * @Date: 2020/5/19 09:14
 * @return version 1.0
 */

@Service
public  class PaymentImplService implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getByPaySerial(String serial) {
        return paymentDao.getByPaySerial(serial);
    }
}
