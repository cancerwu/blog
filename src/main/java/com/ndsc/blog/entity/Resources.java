package com.ndsc.blog.entity;


import java.util.Date;

public class Resources {
    private Integer resourcesId;

    private String resourcesName;

    private String resourcesAddress;

    private Integer uploaderId;

    private Date resourcesCreateTime;

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName == null ? null : resourcesName.trim();
    }

    public String getResourcesAddress() {
        return resourcesAddress;
    }

    public void setResourcesAddress(String resourcesAddress) {
        this.resourcesAddress = resourcesAddress == null ? null : resourcesAddress.trim();
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
    }

    public Date getResourcesCreateTime() {
        return resourcesCreateTime;
    }

    public void setResourcesCreateTime(Date resourcesCreateTime) {
        this.resourcesCreateTime = resourcesCreateTime;
    }
}