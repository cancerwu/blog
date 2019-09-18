package com.ndsc.blog.service;

public interface LoginService {

    public String selectByLogin(String userinput, String userPassword);
    public  String selectByPhone(String userTel);

    public int becomeVip(Integer userId);
}
