package com.ndsc.blog.service;

import com.ndsc.blog.entity.Userinfo;
import com.ndsc.blog.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 扶明方
 * @Date 2019/9/16 15:58
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo selectByUserId(Integer userId) {
        return userinfoMapper.selectUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }
}
