package com.ndsc.blog.service;

import com.ndsc.blog.entity.Relation;

public interface RelationService {
    public int addFollow(int blogerId,int fansId);
    public int delFollow(int blogerId,int fansId);
    public Relation viewFollow(int blogerId,int fansId);
}
