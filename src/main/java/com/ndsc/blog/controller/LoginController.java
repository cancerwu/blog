package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Userinfo;
import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.mapper.UsersafeMapper;
import com.ndsc.blog.service.LoginService;
import com.ndsc.blog.service.Md5Encryption;
import com.ndsc.blog.service.UserInfoService;
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
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/getUserInfo")
    public Userinfo getUserInfo(HttpServletRequest request) {
        try {

            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("userName");
            int userId = usersafeMapper.selectUserId(userName);
            return userInfoService.selectByUserId(userId);
        }catch (Exception e ){
            return null;
        }
    }

    @RequestMapping("/login")
    public String selectByLogin(String userName, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        password = md5Encryption.encrype(password);
        String resultUserName = loginService.selectByLogin(userName, password);
        session.setAttribute("userName", resultUserName);
        System.out.println("---------" + session.getAttribute("userName") + "登陆成功");
        return resultUserName;
    }

    @RequestMapping("/login1")
    public Usersafe selectByLogin1(String userName, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        password = md5Encryption.encrype(password);
        Usersafe usersafe = new Usersafe();

        try {
            String resultUserName = loginService.selectByLogin(userName, password);
            session.setAttribute("userName", resultUserName);
            int userId = usersafeMapper.selectUserId(userName);
            System.out.println("---------" + session.getAttribute("userName") + "登陆成功");
            usersafe = usersafeMapper.selectByPrimaryKey(userId);
            return usersafe;
        } catch (Exception e) {
            e.printStackTrace();
            return usersafe;
        }

    }

    @RequestMapping("/phoneLogin")
    public String phoneLogin(String userTel, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String resultUserName = loginService.selectByPhone(userTel);
        session.setAttribute("userName", resultUserName);
        System.out.println("---------" + session.getAttribute("userName") + "登陆成功");
        return resultUserName;
    }

    @RequestMapping("/getLoginUserName")
    public String getLoginUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println(session.getAttribute("userName") + "在线");
        return userName;
    }

    @RequestMapping("/getUserId")
    public Integer getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println(userName);
        try {
            Integer userId = usersafeMapper.selectUserId(userName);
            System.out.println(userId);
            return userId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/outline")
    public int outline(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", null);
        System.out.println("下线成功");
        return 0;
    }
}
