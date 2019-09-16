package com.ndsc.blog.service;

import com.ndsc.blog.entity.Userinfo;

/**
 * @Author 扶明方
 * @Date 2019/9/16 15:57
 * @Version 1.0
 */
public interface UserInfoService {
    Userinfo selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Userinfo record);
}
