package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    SearchService searchService;
    @RequestMapping("/solr/save")
    public  String save(@RequestBody Blog blog){
        int ret =searchService.addBlog(blog);
        if (ret==0)
        {
            return "success save!";
        }
        else {
            return "error";
        }
    }
    @RequestMapping("/solr/get")
    public Blog selectById(int id){
        return searchService.getBlogById(id);
    }
    @RequestMapping("/solr/search")
    public List<Blog> search(String keyword){
        return searchService.searchBlog(keyword);
    }
}
