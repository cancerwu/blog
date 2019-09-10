package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Relation;

public interface RelationMapper {
    int insert(Relation record);

    int insertSelective(Relation record);
}