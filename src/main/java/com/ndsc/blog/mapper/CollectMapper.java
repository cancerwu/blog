package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Blog;
import com.ndsc.blog.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectMapper {
    int insertCollection(Collect collection);

    List<Blog> selectCollectionBlog(Integer collectionId);

    int deleteCollection(Collect collection);
}
