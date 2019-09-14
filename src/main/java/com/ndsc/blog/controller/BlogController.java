package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/insertblog")
    public int insertBlog(Blog blog){
        blogService.insertBlog(blog);
        return 0;
    }
}
