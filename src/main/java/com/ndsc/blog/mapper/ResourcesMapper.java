package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Resources;

public interface ResourcesMapper {
    int deleteByPrimaryKey(Integer resources_id);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(Integer resources_id);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}