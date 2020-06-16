package com.psf.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName： user
 * @Auther: Administrator
 * @Date: 2020/6/12 16:42
 * @return version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String name;

}
