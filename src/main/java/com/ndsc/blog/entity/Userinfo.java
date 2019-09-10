package com.ndsc.blog.entity;

import java.util.Date;

public class Userinfo {
    private Integer userinfo_id;

    private String real_name;

    private String user_sex;

    private Date user_birthday;

    private String user_pic;

    private Date user_create_time;

    private Integer user_id;

    public Integer getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(Integer userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex == null ? null : user_sex.trim();
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic == null ? null : user_pic.trim();
    }

    public Date getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}