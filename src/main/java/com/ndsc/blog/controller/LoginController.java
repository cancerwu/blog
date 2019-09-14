package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.mapper.UsersafeMapper;
import com.ndsc.blog.service.LoginService;
import com.ndsc.blog.service.Md5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UsersafeMapper usersafeMapper;
    @Autowired
    Md5Encryption md5Encryption;

    @PostMapping("/login")
    public Usersafe selectByLogin(String userinput, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
         password=md5Encryption.encrype(password);
        String resultUserName = loginService.selectByLogin(userinput, password);
        session.setAttribute("userName", resultUserName);
        int userId = usersafeMapper.selectUserId(resultUserName);
        Usersafe usersafe=usersafeMapper.selectByPrimaryKey(userId);
        System.out.println("---------" + session.getAttribute("userName") + "登陆成功");
        return usersafe;
    }

    @RequestMapping("/getLoginUserName")
    public String getLoginUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println(session.getAttribute("userName") + "在线");
        return userName;
    }

    @RequestMapping("/getUserId")
    public int getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println(userName);
        int userId = usersafeMapper.selectUserId(userName);
        System.out.println(userId);
        return userId;
    }

    @RequestMapping("/outline")
    public int outline(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", null);
        System.out.println("下线成功");
        return 0;

    }


}
