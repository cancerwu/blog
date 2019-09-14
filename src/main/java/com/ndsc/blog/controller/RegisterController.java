package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.service.Md5Encryption;
import com.ndsc.blog.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RegisterController {

    @Resource
    @Autowired
    private RegisterService registerService;
    @Autowired
    Md5Encryption md5Encryption;

    @RequestMapping("/register")
    public int insertUser(Usersafe usersafe) {
//        String pwd=usersafe.getPassword();
//        pwd=md5Encryption.encrype(pwd);
//        usersafe.setPassword(pwd);
        usersafe.setPassword(md5Encryption.encrype(usersafe.getPassword()));
        registerService.insertUser(usersafe);
        return 0;
    }

    @RequestMapping("/checkSamePhone")
    public int checkSamePhone(String userTel) {
        return registerService.checkSamePhone(userTel);
    }

    @RequestMapping("/checkSameName")
    public int checkSameName(String userName) {
        return registerService.checkSameName(userName);
    }

    @RequestMapping("/checkSameEmail")
    public int checkSameEmail(String userEmail) {
        return registerService.checkSameEmail(userEmail);
    }
}
