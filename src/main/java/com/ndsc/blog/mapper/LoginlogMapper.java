package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Loginlog;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Integer loginlogId);

    int insert(Loginlog record);

    int insertSelective(Loginlog record);

    Loginlog selectByPrimaryKey(Integer loginlogId);

    int updateByPrimaryKeySelective(Loginlog record);

    int updateByPrimaryKey(Loginlog record);
}