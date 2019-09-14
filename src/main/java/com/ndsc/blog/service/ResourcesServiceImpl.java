package com.ndsc.blog.service;

import com.ndsc.blog.entity.Resources;
import com.ndsc.blog.mapper.ResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 扶明方
 * @Date 2019/9/12 21:10
 * @Version 1.0
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    ResourcesMapper resourcesMapper;

    @Override
    public int uploadResource(Resources resources) {
        return resourcesMapper.insertSelective(resources);
    }
}