package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Usersafe;

public interface UsersafeMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(Usersafe record);

    int insertSelective(Usersafe record);

    Usersafe selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(Usersafe record);

    int updateByPrimaryKey(Usersafe record);
}