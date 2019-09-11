package com.ndsc.blog.entity;

import java.util.Date;

public class Loginlog {
    private Integer loginlogId;

    private Integer userId;

    private Date loginTime;

    private String loginIp;

    private String loginAddress;

    public Integer getLoginlogId() {
        return loginlogId;
    }

    public void setLoginlogId(Integer loginlogId) {
        this.loginlogId = loginlogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }
}