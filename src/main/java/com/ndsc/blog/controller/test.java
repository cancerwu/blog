package com.ndsc.blog.controller;


import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.entity.Relation;
import com.ndsc.blog.mapper.BlogMapper;
import com.ndsc.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogService blogService;

    @RequestMapping("/test")
    public Blog test(int id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/removeRelation1")
    public int removeRelation(@RequestBody Relation relation){
        return blogService.deleteRelation(relation);
    }
}
