package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Vip;

public interface VipMapper {
    int deleteByPrimaryKey(Integer vipId);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Integer vipId);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);
}