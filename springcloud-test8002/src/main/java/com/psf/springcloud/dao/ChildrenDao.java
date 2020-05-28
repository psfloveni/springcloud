package com.psf.springcloud.dao;


import com.psf.springcloud.entity.Children;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChildrenDao {

    /**
     * 增
     */
    public int insert(Children children) ;

    /**
     *
     */
    public Children getById(@Param("id") long id);
}
