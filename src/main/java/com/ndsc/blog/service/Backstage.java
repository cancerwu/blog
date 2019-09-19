package com.ndsc.blog.service;

import com.ndsc.blog.entity.Usersafe;

import java.util.List;

public interface Backstage {
   List<Usersafe>  selectAllUsers();
    Usersafe selectUserById(int userId);
    Usersafe selectUserByName(String userName);
    int blockAcccount(int userId);
    int changeAdmin(int userId);
    int countBlog();
    int countUser();
    int countSum();
    int countVip();

}
