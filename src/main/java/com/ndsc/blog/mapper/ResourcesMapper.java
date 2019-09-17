package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Resources;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesMapper {
    int deleteByPrimaryKey(Integer resourcesId);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(Integer resourcesId);

    List<Resources> getAllResources();

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}