package com.ndsc.blog.entity;

public class Relation {
    private Integer bloger_id;

    private Integer fans_id;

    public Integer getBloger_id() {
        return bloger_id;
    }

    public void setBloger_id(Integer bloger_id) {
        this.bloger_id = bloger_id;
    }

    public Integer getFans_id() {
        return fans_id;
    }

    public void setFans_id(Integer fans_id) {
        this.fans_id = fans_id;
    }
}