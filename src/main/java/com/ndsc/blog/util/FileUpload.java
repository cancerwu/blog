package com.ndsc.blog.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;


/**
 * @Author 扶明方
 * @Date 2019/8/31 16:36
 * @Version 1.0
 * 文件上传方法
 */
public class FileUpload {
    public String upload(HttpServletRequest request, MultipartFile file) throws Exception {
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
//            String serverPath = request.getSession().getServletContext().getRealPath("/") + "upload";
            String serverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload";
            System.out.println(serverPath);
            //上传文件名
            String filename = file.getOriginalFilename();
            filename = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis()) + filename;
            File serverFile = new File(serverPath, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!serverFile.getParentFile().exists()) {
                serverFile.getParentFile().mkdirs();
            }
            //将上传文件保存到项目工作目录当中
            file.transferTo(new File(serverPath + File.separator + filename));

           /* //保存至本地
            String LocalPath = "F:\\JetBrains\\IdeaProjects\\blog\\src\\main\\webapp\\upload";
            File LocalFile = new File(LocalPath, filename);
            if (!LocalFile.getParentFile().exists()) {
                LocalFile.getParentFile().mkdirs();
            }
            FileInputStream in = new FileInputStream(serverFile);
            FileOutputStream out = new FileOutputStream(new File(LocalPath, filename));
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = in.read(b)) > 0) {
                out.write(b, 0, len);
            }
            in.close();
            out.close();*/
            return filename;
        }
        return null;
    }
}