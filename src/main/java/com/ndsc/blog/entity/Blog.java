package com.ndsc.blog.entity;

import java.util.Date;

public class Blog {
    private Integer blogId;

    private String blogTitle;

    private Date blogCreateTime;

    private Integer blogPubType;

    private Integer blogReadNum;

    private Integer userId;

    private String blogContent;

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