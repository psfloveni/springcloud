package com.psf.springcloud.controller;


import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.psf.springcloud.entity.Children;
import com.psf.springcloud.entity.CommonReslut;
import com.psf.springcloud.service.ChildrenService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class ChildrenController {

    @Resource
    private ChildrenService childrenService;

    @PostMapping(value = "/children/insert")
    public CommonReslut insert(Children children){

        int insert = childrenService.insert(children);
        log.info("children="+insert);
        if (insert>0){
            return new CommonReslut(200,"增加成功",insert);
        }
        else {
            return new CommonReslut(404,"失败",null);
        }
    }

    @GetMapping(value = "/children/getById/{id}")
    public CommonReslut getById(@PathVariable("id") long id){
        Children children = childrenService.getById(id);
        log.info("children="+children);
        if (children != null){
            return new CommonReslut(200,"查询成功",children);
        }
        else {
            return new CommonReslut(404,"查询失败，查询id="+id,null);
        }
    }
}
