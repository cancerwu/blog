package com.ndsc.blog.service;

import com.ndsc.blog.entity.Order;
import com.ndsc.blog.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author 扶明方
 * @Date 2019/9/12 19:10
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public List<Order> selectOrdersByUserId(Integer userId) {
        return orderMapper.selectOrdersByUserId(userId);
    }
}
