package com.ndsc.blog.entity;

import java.util.Date;

public class Blog {
    private Integer blog_id;

    private String blog_title;

    private Date blog_create_time;

    private Integer blog_pub_type;

    private Integer blog_read_num;

    private Integer user_id;

    private String blog_content;

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title == null ? null : blog_title.trim();
    }

    public Date getBlog_create_time() {
        return blog_create_time;
    }

    public void setBlog_create_time(Date blog_create_time) {
        this.blog_create_time = blog_create_time;
    }

    public Integer getBlog_pub_type() {
        return blog_pub_type;
    }

    public void setBlog_pub_type(Integer blog_pub_type) {
        this.blog_pub_type = blog_pub_type;
    }

    public Integer getBlog_read_num() {
        return blog_read_num;
    }

    public void setBlog_read_num(Integer blog_read_num) {
        this.blog_read_num = blog_read_num;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content == null ? null : blog_content.trim();
    }
}