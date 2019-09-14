package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Resources;
import com.ndsc.blog.service.ResourcesService;
import com.ndsc.blog.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author 扶明方
 * @Date 2019/9/12 21:11
 * @Version 1.0
 */
@RestController
public class ResourcesController {
    @Autowired
    ResourcesService resourcesService;

    @RequestMapping("uploadResource")
    public String uploadResource(Resources resources, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //resources.setUploaderId(new LoginController().getUserId(request));
        try {
            resources.setResourcesAddress(new FileUpload().upload(request, file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resourcesService.uploadResource(resources);
        return "<a id=\"ak\" href='uploadSuccess.html'>跳转</a>\n" +
                "<script>\n" +
                "    document.getElementById(\"ak\").click();\n" +
                "</script>";
    }
}
