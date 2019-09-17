package com.ndsc.blog.controller;

import com.ndsc.blog.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

@Controller
public class SendSmsController {
    @Autowired
    @Resource
    private SendSmsService sendSmsService;
    @RequestMapping("/getSmsCode")
    @ResponseBody
    public String getCheckCode(String userTel) {
        String code = String.valueOf(new Random().nextInt(899999) + 100000);

        try {
            sendSmsService.sendSms(userTel,code);
        } catch (Exception e) {
            return "";
        }
        return code;
    }
}
