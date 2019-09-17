package com.ndsc.blog.service;

import com.ndsc.blog.entity.Vip;
import com.ndsc.blog.mapper.VipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 扶明方
 * @Date 2019/9/12 20:44
 * @Version 1.0
 */
@Service
public class VipServiceImpl implements VipService {
    @Autowired
    VipMapper vipMapper;

    @Override
    public List<Vip> selectAll() {
        return vipMapper.selectAll();
    }

    @Override
    public Vip selectById(Integer vipId) {
        return vipMapper.selectById(vipId);
    }
}
