package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;

public interface BlogService {
    public int insertBlog(Blog record);
}
