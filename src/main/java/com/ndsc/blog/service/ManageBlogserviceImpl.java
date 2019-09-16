package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.mapper.BlogMapper;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ManageBlogserviceImpl implements ManageBlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    private SolrTemplate solrTemplate;
    @Override
    public int addBlog(Blog blog) {
        //像数据库插入数据
        blogMapper.insert(blog);
        //维护solr
        UpdateResponse updateResponse =solrTemplate.saveBean("blog", blog, Duration.ZERO);
        solrTemplate.commit("blog");

        return updateResponse.getStatus();
    }

    @Override
    public List<Blog> searchUserBlog(int userId) {
        List<Blog> userBlogs =  blogMapper.searchUserBlog(userId);
        return userBlogs;
    }

    @Override
    //返回1失败返回 0成功
    public int deleteBlogByBlogId(Integer blogId) {
        try{
            blogMapper.deleteByPrimaryKey(blogId);
            //维护solr
            UpdateResponse updateResponse = solrTemplate.deleteByIds("blog",blogId.toString());
            return updateResponse.getStatus();//0 表示成功
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }
}
