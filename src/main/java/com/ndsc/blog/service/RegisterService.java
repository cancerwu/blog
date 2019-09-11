package com.ndsc.blog.service;

import com.ndsc.blog.entity.Usersafe;

public interface RegisterService {
    public int insertUser(Usersafe usersafe);

    public int checkSamePhone(String userTel);

    public int checkSameName(String userName);
}
