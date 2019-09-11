package com.ndsc.blog.entity;

public class Vip {
    private Integer vip_id;

    private String vip_name;

    private Integer vip_price;

    private String vip_description;

    public Integer getVip_id() {
        return vip_id;
    }

    public void setVip_id(Integer vip_id) {
        this.vip_id = vip_id;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name == null ? null : vip_name.trim();
    }

    public Integer getVip_price() {
        return vip_price;
    }

    public void setVip_price(Integer vip_price) {
        this.vip_price = vip_price;
    }

    public String getVip_description() {
        return vip_description;
    }

    public void setVip_description(String vip_description) {
        this.vip_description = vip_description == null ? null : vip_description.trim();
    }
}