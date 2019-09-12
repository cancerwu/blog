package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}