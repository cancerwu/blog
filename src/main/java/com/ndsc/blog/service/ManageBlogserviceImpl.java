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
        blog.setBlogTitle((String)itemMap.get("blogTitle"));
        blog.setBlogContent((String)itemMap.get("blogContent"));
        blog.setBlogPubType((Integer)itemMap.get("BlogPubType"));
        blog.setUserId((Integer)itemMap.get("userId"));
        Integer tagId=(Integer)itemMap.get("tagId");
        int blogId = blogMapper.insert(blog);
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
