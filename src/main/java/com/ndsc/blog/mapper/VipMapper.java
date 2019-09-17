package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Vip;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipMapper {
    int deleteByPrimaryKey(Integer vipId);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Integer vipId);

    List<Vip> selectAll();

    Vip selectById(Integer vipId);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);
}