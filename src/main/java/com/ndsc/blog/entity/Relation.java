package com.ndsc.blog.entity;

public class Relation {
    private Integer blogerId;

    private Integer fansId;

    public Integer getBlogerId() {
        return blogerId;
    }

    public void setBlogerId(Integer blogerId) {
        this.blogerId = blogerId;
    }

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }
}