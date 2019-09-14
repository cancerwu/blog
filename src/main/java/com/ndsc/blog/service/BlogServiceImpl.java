package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Override
    public int insertBlog(Blog record) {
        blogMapper.insert(record);
        return 0;
    }
}
