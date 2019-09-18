package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Resources;
import com.ndsc.blog.entity.Userinfo;
import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.mapper.UsersafeMapper;
import com.ndsc.blog.service.ResourcesService;
import com.ndsc.blog.service.UserInfoService;
import com.ndsc.blog.util.FileUpload;
import com.ndsc.blog.util.faceUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * @Author 扶明方
 * @Date 2019/9/12 21:11
 * @Version 1.0
 */
@RestController
public class ResourcesController {
    @Autowired
    ResourcesService resourcesService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UsersafeMapper usersafeMapper;

    @RequestMapping("test")
    public void test(HttpServletRequest request) {
        System.out.println(System.getProperty("user.dir"));
    }

    //上传文件
    @RequestMapping("upload")
    public String uploadResource(Resources resources, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //获取id
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int id = usersafeMapper.selectUserId(userName);
        resources.setUploaderId(id);
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

    //上传头像的
    @RequestMapping("uploadFace")
    public String uploadFace(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //获取id
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int id = usersafeMapper.selectUserId(userName);

        Userinfo userinfo = userInfoService.selectByUserId(id);
        try {
            userinfo.setUserPic(new faceUpload().upload(request, file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        userInfoService.updateByPrimaryKeySelective(userinfo);
        return "<a id=\"ak\" href='userinfoindex.html'>跳转</a>\n" +
                "<script>\n" +
                "    document.getElementById(\"ak\").click();\n" +
                "</script>";
    }

    @RequestMapping("download")
    public String downloadResource(String fileName, HttpServletRequest request, HttpServletResponse response) {
        //文件路径
//        String serverPath = request.getSession().getServletContext().getRealPath("/") + "upload";
        String serverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload";

        File file = new File(serverPath, fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开            
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

    @RequestMapping("getAllResources")
    public List<Resources> getAllResources() {
        return resourcesService.getAllResources();
    }

    @RequestMapping("getUser")
    public Usersafe getUser(Integer userId) {
        return usersafeMapper.selectByPrimaryKey(userId);
    }
}
