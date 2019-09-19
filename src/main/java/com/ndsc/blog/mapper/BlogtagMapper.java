package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.entity.Blogtag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogtagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Blogtag record);


    int insertSelective(Blogtag record);

    Blogtag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Blogtag record);

    int updateByPrimaryKey(Blogtag record);

    //************************************
    List<Blog> selectByBlogtagGetBlog(String tagName);
}