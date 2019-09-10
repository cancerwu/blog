package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Tag;

public interface TagMapper {
    int insert(Tag record);

    int insertSelective(Tag record);
}