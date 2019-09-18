package com.ndsc.blog.service;

import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.mapper.UsersafeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackstageImpl implements Backstage {
   @Autowired
    UsersafeMapper usersafeMapper;

    @Override
    public Usersafe selectAllUsers() {
        return usersafeMapper.selectAllUsers();
    }

    @Override
    public Usersafe selectUserById(int userId) {
        return null;
    }

    @Override
    public Usersafe selectUserByName(String userName) {
        return null;
    }
}
