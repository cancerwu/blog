package com.ndsc.blog.entity;

public class Vip {
    private Integer vipId;

    private String vipName;

    private Integer vipPrice;

    private String vipDescription;

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName == null ? null : vipName.trim();
    }

    public Integer getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Integer vipPrice) {
        this.vipPrice = vipPrice;
    }

    public String getVipDescription() {
        return vipDescription;
    }

    public void setVipDescription(String vipDescription) {
        this.vipDescription = vipDescription == null ? null : vipDescription.trim();
    }
}