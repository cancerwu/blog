package com.ndsc.blog.service;

import com.ndsc.blog.entity.*;
import com.ndsc.blog.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    RelationMapper relationMapper;

    @Autowired
    UsersafeMapper usersafeMapper;

    @Autowired
    BlogtagMapper blogtagMapper;

    @Autowired
    CollectMapper collectMapper;


    //********************userinfo***************
    @Override
    public Userinfo selectUserId(Integer userId) {
        return userinfoMapper.selectUserId(userId);
    }

    @Override
    public int updateUserinfo(Userinfo userinfo) {
        return userinfoMapper.updateUserinfo(userinfo);
    }

    @Override
    public Userinfo selectByUserinfoGetBlog(Integer userId) {
        return userinfoMapper.selectByUserinfoGetBlog(userId);
    }

    //***********relation*********************
    @Override
    public int insertRelation(Relation relation) {
        return relationMapper.insertRelation(relation);
    }

    @Override
    public List<Usersafe> selectRelationUser(Integer fansId) {
        return relationMapper.selectRelationUser(fansId);
    }

    @Override
    public int deleteRelation(Relation relation) {
        return relationMapper.deleteRelation(relation);
    }

    @Override
    public List<Usersafe> selectFans(Integer blogerId) {
        return relationMapper.selectFans(blogerId);
    }

    //************************usersafe*******************
    @Override
    public int updateUsersafe(Usersafe usersafe) {
        return usersafeMapper.updateUsersafe(usersafe);
    }

    //************************************
    @Override
    public List<Blog> selectByBlogtagGetBlog(String tagName) {
        return blogtagMapper.selectByBlogtagGetBlog(tagName);
    }

    //****************************
    @Override
    public int insertCollection(com.ndsc.blog.entity.Collect collection) {
        return collectMapper.insertCollection(collection);
    }

    @Override
    public List<Blog> selectCollectionBlog(Integer collectionId) {
        return collectMapper.selectCollectionBlog(collectionId);
    }

    @Override
    public int deleteCollection(com.ndsc.blog.entity.Collect collection) {
        return collectMapper.deleteCollection(collection);
    }
    //****************************

    @Override
    public int selectFansCount(Integer blogerId) {
        return relationMapper.selectFansCount(blogerId);
    }

    @Override
    public int selectBlogerCount(Integer fansId) {
        return relationMapper.selectBlogerCount(fansId);
    }

    @Override
    public int selectCollectionCount(Integer collectionId) {
        return collectMapper.selectCollectionCount(collectionId);
    }

    @Override
    public Usersafe selectUidUsafeUinfoBlog(Integer userId) {
        return usersafeMapper.selectUidUsafeUinfoBlog(userId);
    }

    @Override
    public Usersafe selectUnameUsafeUinfoBlog(String userName) {
        return usersafeMapper.selectUnameUsafeUinfoBlog(userName);
    }

    @Override
    public Usersafe selectBlogUsafeUname(Integer blogId) {
        return usersafeMapper.selectBlogUsafeUname(blogId);
    }

    @Override
    public int selectBlogCount(Integer userId) {
        return usersafeMapper.selectBlogCount(userId);
    }
    //****************************


}
