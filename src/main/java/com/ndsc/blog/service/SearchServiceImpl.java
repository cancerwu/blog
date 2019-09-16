package com.ndsc.blog.service;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.mapper.BlogMapper;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SolrTemplate solrTemplate;
    @Autowired
    private BlogMapper blogMapper;


    @Override
    public List<Blog> searchBlog(String keyword) {
        Query query=new SimpleQuery();
        //设置条件
        Criteria criteria=new Criteria("blogTitle").is(keyword);
        query.addCriteria(criteria);
        //设置分页
        query.setOffset(0l);
        query.setRows(10);
        //设置排序规则
         Sort sort=new Sort(Sort.Direction.ASC, "id");
        query.addSort(sort);
        //查询
        ScoredPage<Blog> pages =solrTemplate.queryForPage("blog", query, Blog.class);
        System.out.println("pages.getTotal="+pages.getTotalElements());
        List<Blog> content=pages.getContent();
      System.out.println("sousuo chenggong ");
        return content;
    }

    @Override
    public Blog getBlogById(Integer blogid) {
        return blogMapper.selectByPrimaryKey(blogid);
    }
}
