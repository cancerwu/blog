package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Blog;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer blog_id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer blog_id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}