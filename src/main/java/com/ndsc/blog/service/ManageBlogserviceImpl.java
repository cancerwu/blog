package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.mapper.BlogMapper;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManageBlogserviceImpl implements ManageBlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    private SolrTemplate solrTemplate;
    @Override
    public int addBlog(Map itemMap) {
        //像数据库插入数据
        Blog blog = new Blog();
        blog.setBlogTitle(itemMap.get("blogTitle").toString());
        blog.setBlogContent(itemMap.get("blogContent").toString());
        blog.setBlogPubType(Integer.parseInt(itemMap.get("blogPubType").toString()));
//        blog.setUserId((Integer)itemMap.get("userId"));
        blog.setUserId(Integer.parseInt(itemMap.get("userId").toString()));
        Integer tagId= Integer.parseInt(itemMap.get("tagId").toString());
        blogMapper.insert(blog);
        Integer blogId = blog.getBlogId();
        Map<String,Integer> tagMap =new HashMap<String, Integer>();
        tagMap.put("blogId",blogId);
        tagMap.put("tagId",tagId);
        blogMapper.insertTag(tagMap);
//        int blogId = blog.getBlogId();
//        blogMapper.insertTag(blogId,tagId);
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
