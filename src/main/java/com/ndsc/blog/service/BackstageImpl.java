package com.ndsc.blog.service;

import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.mapper.OrderMapper;
import com.ndsc.blog.mapper.UsersafeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackstageImpl implements Backstage {
   @Autowired
    UsersafeMapper usersafeMapper;
@Autowired
    OrderMapper orderMapper;
    @Override
    public List<Usersafe> selectAllUsers() {
        return usersafeMapper.selectAllUsers();
    }

    @Override
    public Usersafe selectUserById(int userId) {
        return usersafeMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Usersafe selectUserByName(String userName) {
        return usersafeMapper.selectUserByName(userName);
    }

    @Override
    public int blockAcccount(int userId) {
        return usersafeMapper.blockAcccount(userId);
    }

    @Override
    public int countBlog() {
        return usersafeMapper.countBlog();
    }

    @Override
    public int countUser() {
        return usersafeMapper.countUser();
    }

    @Override
    public int countSum() {
        return orderMapper.countSum();
    }
}
