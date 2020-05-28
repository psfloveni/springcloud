package com.psf.springcloud.dao;

import com.psf.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName： PaymentDao
 * @Auther: Administrator
 * @Date: 2020/5/19 08:58
 * @return version 1.0
 */

@Mapper
public interface PaymentDao {

    public int insert(Payment payment);

    public Payment getByPaySerial(@Param("serial")String serial);
}
