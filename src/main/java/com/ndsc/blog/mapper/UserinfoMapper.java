package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer userinfoId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userinfoId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    //*******************************
    Userinfo selectUserId(Integer userId);

    int updateUserinfo(Userinfo userinfo);

    Userinfo selectByUserinfoGetBlog(Integer userId);
    //*******************************
}