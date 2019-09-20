package com.ndsc.blog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

@SolrDocument(solrCoreName = "blog")
public class Blog {

    @Indexed
    private Integer blogId;
    @Indexed
    private String blogTitle;

    private Date blogCreateTime;

    private Integer blogPubType;
    @Indexed
    private Integer blogReadNum;
    @Indexed
    private Integer userId;

    private String blogContent;

    private Userinfo userinfo;

    @Id
    @Indexed
    private String id;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Date getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(Date blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public Integer getBlogPubType() {
        return blogPubType;
    }

    public void setBlogPubType(Integer blogPubType) {
        this.blogPubType = blogPubType;
    }

    public Integer getBlogReadNum() {
        return blogReadNum;
    }

    public void setBlogReadNum(Integer blogReadNum) {
        this.blogReadNum = blogReadNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}