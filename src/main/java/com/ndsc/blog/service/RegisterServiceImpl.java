package com.ndsc.blog.service;

import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.mapper.UsersafeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService {


    @Resource
    @Autowired
    private UsersafeMapper usersafeMapper;

    @Override
    public int insertUser(Usersafe userSafe) {
        usersafeMapper.insert(userSafe);
        return 0;
    }

    @Override
    public int checkSamePhone(String userTel) {
        return usersafeMapper.sameTel(userTel);
    }

    @Override
    public int checkSameName(String userName) {
        return usersafeMapper.sameName(userName);
    }

    @Override
    public int checkSameEmail(String userEmail) {
        return usersafeMapper.sameEmail(userEmail);
    }

}
