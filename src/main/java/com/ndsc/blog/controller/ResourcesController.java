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
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author 扶明方
 * @Date 2019/9/12 21:11
 * @Version 1.0
 */
@RestController
public class ResourcesController {
    @Autowired
    ResourcesService resourcesService;

    @RequestMapping("upload")
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

    @RequestMapping("download")
    public String downloadResource(String fileName, HttpServletRequest request, HttpServletResponse response) {
        //文件路径
        String serverPath = request.getSession().getServletContext().getRealPath("/") + "upload";
        File file = new File(serverPath,fileName);
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
}
