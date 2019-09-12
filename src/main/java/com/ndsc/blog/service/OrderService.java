package com.ndsc.blog.service;

import com.ndsc.blog.entity.Order;

import java.util.List;

/**
 * @Author 扶明方
 * @Date 2019/9/12 19:10
 * @Version 1.0
 */
public interface OrderService {
    public int insertOrder(Order order);

    public List<Order> selectOrdersByUserId(Integer userId);
}
