package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Usersafe;

public interface UsersafeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Usersafe record);

    int insertSelective(Usersafe record);

    Usersafe selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Usersafe record);

    int updateByPrimaryKey(Usersafe record);
}