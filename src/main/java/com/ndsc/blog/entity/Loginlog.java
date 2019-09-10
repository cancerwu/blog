package com.ndsc.blog.entity;

import java.util.Date;

public class Loginlog {
    private Integer loginlog_id;

    private Integer user_id;

    private Date login_time;

    private String login_ip;

    private String login_address;

    public Integer getLoginlog_id() {
        return loginlog_id;
    }

    public void setLoginlog_id(Integer loginlog_id) {
        this.loginlog_id = loginlog_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip == null ? null : login_ip.trim();
    }

    public String getLogin_address() {
        return login_address;
    }

    public void setLogin_address(String login_address) {
        this.login_address = login_address == null ? null : login_address.trim();
    }
}