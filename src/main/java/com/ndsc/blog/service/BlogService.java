package com.ndsc.blog.service;

import com.ndsc.blog.entity.*;

import java.util.List;

public interface BlogService {


    Userinfo selectUserId(Integer userId);

    int updateUserinfo(Userinfo userinfo);

    Userinfo selectByUserinfoGetBlog(Integer userId);
    //***********************
    int insertRelation(Relation relation);

    List<Userinfo> selectRelationUser(Integer fansId);

    int deleteRelation(Relation relation);

    List<Userinfo> selectFans(Integer blogerId);
    //**********************

    //**************usersafe*******************
    int updateUsersafe(Usersafe usersafe);
    //***********************
    //************************************
    List<Blog> selectByBlogtagGetBlog(String tagName);
    //**********************
    int insertCollection(com.ndsc.blog.entity.Collect collection);

    List<Blog> selectCollectionBlog(Integer collectionId);

    int deleteCollection(com.ndsc.blog.entity.Collect collection);

    int selectFansCount(Integer blogerId);

    int selectBlogerCount(Integer fansId);

    int selectCollectionCount(Integer collectionId);

    Usersafe selectUidUsafeUinfoBlog(Integer userId);

    Usersafe selectUnameUsafeUinfoBlog(String userName);


}
