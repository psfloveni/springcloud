package com.psf.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonReslut<T> {

    private  Integer code;
    private String Message;
    private T  data;

    public CommonReslut(Integer code, String message) {
        this(code,message,null);
    }

}
