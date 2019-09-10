package com.ndsc.blog.entity;

public class Usersafe {
    private Integer user_id;

    private String user_name;

    private String password;

    private String user_email;

    private String user_tel;

    private Integer user_status;

    private Integer user_money;

    private Integer user_integral;

    private Integer user_role;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email == null ? null : user_email.trim();
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel == null ? null : user_tel.trim();
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public Integer getUser_money() {
        return user_money;
    }

    public void setUser_money(Integer user_money) {
        this.user_money = user_money;
    }

    public Integer getUser_integral() {
        return user_integral;
    }

    public void setUser_integral(Integer user_integral) {
        this.user_integral = user_integral;
    }

    public Integer getUser_role() {
        return user_role;
    }

    public void setUser_role(Integer user_role) {
        this.user_role = user_role;
    }
}