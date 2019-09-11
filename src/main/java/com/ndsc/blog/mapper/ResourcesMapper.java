package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Resources;

public interface ResourcesMapper {
    int deleteByPrimaryKey(Integer resourcesId);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(Integer resourcesId);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}