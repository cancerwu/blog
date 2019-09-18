package com.ndsc.blog.service;

import com.ndsc.blog.entity.Vip;

import java.util.List;

/**
 * @Author 扶明方
 * @Date 2019/9/12 20:44
 * @Version 1.0
 */
public interface VipService {
    List<Vip> selectAll();

    Vip selectById(Integer vipId);
}
