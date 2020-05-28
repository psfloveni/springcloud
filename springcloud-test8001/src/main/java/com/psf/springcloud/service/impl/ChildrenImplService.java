package com.psf.springcloud.service.impl;

import com.psf.springcloud.dao.ChildrenDao;
import com.psf.springcloud.entity.Children;
import com.psf.springcloud.service.ChildrenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChildrenImplService implements ChildrenService {

    @Resource
    private ChildrenDao childrenDao;

    @Override
    public int insert(Children children) {
        return childrenDao.insert(children);
    }

    @Override
    public Children getById(long id) {
        return childrenDao.getById(id);
    }
}
