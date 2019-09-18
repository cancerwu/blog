package com.ndsc.blog.service;

import com.ndsc.blog.entity.Usersafe;

public interface Backstage {
    Usersafe selectAllUsers();
    Usersafe selectUserById(int userId);
    Usersafe selectUserByName(String userName);

}
