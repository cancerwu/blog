package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Usersafe;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper

@Repository
public interface UsersafeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Usersafe record);

    int insertSelective(Usersafe record);

    Usersafe selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Usersafe record);

    int updateByPrimaryKey(Usersafe record);

    int sameTel(String userTel);
    int sameName(String userName);
}