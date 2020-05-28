package com.psf.springcloud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 */
//生成get set 等
@Data
//生成全参
@AllArgsConstructor
//生成无参
@NoArgsConstructor
public class Children implements Serializable {

    private long id;
    private String name;
}
