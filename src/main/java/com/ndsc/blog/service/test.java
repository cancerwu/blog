package com.ndsc.blog.service;

public class test {
    public static void main(String[] args) {
     Md5EncryptionImpl md5Encryption=new Md5EncryptionImpl();
        String pass="123";
        pass=md5Encryption.encrype(pass);
        System.out.println(pass);
    }
}
