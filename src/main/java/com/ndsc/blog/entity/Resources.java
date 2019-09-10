package com.ndsc.blog.entity;

import java.util.Date;

public class Resources {
    private Integer resources_id;

    private String resources_name;

    private String resources_address;

    private Integer uploader_id;

    private Date resources_create_time;

    public Integer getResources_id() {
        return resources_id;
    }

    public void setResources_id(Integer resources_id) {
        this.resources_id = resources_id;
    }

    public String getResources_name() {
        return resources_name;
    }

    public void setResources_name(String resources_name) {
        this.resources_name = resources_name == null ? null : resources_name.trim();
    }

    public String getResources_address() {
        return resources_address;
    }

    public void setResources_address(String resources_address) {
        this.resources_address = resources_address == null ? null : resources_address.trim();
    }

    public Integer getUploader_id() {
        return uploader_id;
    }

    public void setUploader_id(Integer uploader_id) {
        this.uploader_id = uploader_id;
    }

    public Date getResources_create_time() {
        return resources_create_time;
    }

    public void setResources_create_time(Date resources_create_time) {
        this.resources_create_time = resources_create_time;
    }
}