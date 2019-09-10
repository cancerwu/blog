package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer role_id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}