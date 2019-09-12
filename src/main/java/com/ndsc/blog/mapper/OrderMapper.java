package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}