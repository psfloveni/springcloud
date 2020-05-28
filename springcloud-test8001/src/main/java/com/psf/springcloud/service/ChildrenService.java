package com.psf.springcloud.service;

import com.psf.springcloud.entity.Children;
import org.apache.ibatis.annotations.Param;

public interface ChildrenService {

    /**
     * 增
     */
    public int insert(Children children) ;

    /**
     *
     */
    public Children getById(long id);
}
