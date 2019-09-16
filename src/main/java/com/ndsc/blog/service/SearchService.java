package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;

import java.util.List;

public interface SearchService {

    public List<Blog> searchBlog(String keyword);
    public Blog getBlogById(int id);
}
