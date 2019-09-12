package com.ndsc.blog.controller;


import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    BlogMapper blogMapper;

    @RequestMapping("/test")
    public Blog test(int id) {
        return blogMapper.selectByPrimaryKey(id);
    }

}
