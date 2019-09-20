package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface ManageBlogService {
    public int addBlog(Map itemMap);
    List<Blog> searchUserBlog(int userId);
    int deleteBlogByBlogId(Integer blogId);
}
