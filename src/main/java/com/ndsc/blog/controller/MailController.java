package com.ndsc.blog.controller;


import com.ndsc.blog.service.IMailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

@Controller
public class MailController {

    @Resource
    private IMailService mailService;

    @RequestMapping("/getCheckCode")
    @ResponseBody
    public String getCheckCode(String email) {
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为：" + checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        } catch (Exception e) {
            return "";
        }
        return checkCode;
    }

}
