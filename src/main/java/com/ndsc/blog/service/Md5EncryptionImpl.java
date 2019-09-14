package com.ndsc.blog.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class Md5EncryptionImpl implements Md5Encryption{
    @Override
    public String encrype(String password) {
        String pwd=null;
        try{
            MessageDigest md5=MessageDigest.getInstance("md5");
            byte[] b =password.getBytes();
            byte[] digest=md5.digest(b);
            char[] chars=new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            StringBuffer sb=new StringBuffer();
            for(byte bb:digest)
            {
                sb.append(chars[(bb>>4)&15]);
                sb.append(chars[bb&15]);
            }
             pwd= new String(sb);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return pwd;
    }
    //MD5 加密服务

}
