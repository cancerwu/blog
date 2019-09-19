package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectOrdersByUserId(Integer userId);

    int countSum();

    int isVip(Integer userId);
}