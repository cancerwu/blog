package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Vip;

public interface VipMapper {
    int deleteByPrimaryKey(Integer vip_id);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Integer vip_id);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);
}