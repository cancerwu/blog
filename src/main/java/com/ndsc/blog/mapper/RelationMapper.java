package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Relation;
import com.ndsc.blog.entity.Userinfo;
import com.ndsc.blog.entity.Usersafe;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RelationMapper {
    int insert(Relation record);

    int insertSelective(Relation record);

    //***********************
    int insertRelation(Relation relation);

    List<Usersafe> selectRelationUser(Integer fansId);

    int deleteRelation(Relation relation);

    List<Usersafe> selectFans(Integer blogerId);

    //**********************
    //**********************
    int selectFansCount(Integer blogerId);

    int selectBlogerCount(Integer fansId);

    int isFans(Relation relation);
}