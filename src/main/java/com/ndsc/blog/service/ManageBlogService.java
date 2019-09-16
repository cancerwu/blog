package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;

import java.util.List;

public interface ManageBlogService {
    public int addBlog(Blog blog);
    List<Blog> searchUserBlog(int userId);
    int deleteBlogByBlogId(Integer blogId);
}
