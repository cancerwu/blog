package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Blogtag;

public interface BlogtagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Blogtag record);

    int insertSelective(Blogtag record);

    Blogtag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Blogtag record);

    int updateByPrimaryKey(Blogtag record);
}