package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Blogtag;

public interface BlogtagMapper {
    int deleteByPrimaryKey(Integer tag_id);

    int insert(Blogtag record);

    int insertSelective(Blogtag record);

    Blogtag selectByPrimaryKey(Integer tag_id);

    int updateByPrimaryKeySelective(Blogtag record);

    int updateByPrimaryKey(Blogtag record);
}