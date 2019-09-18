package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Usersafe;
import com.ndsc.blog.service.Backstage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BackstageController {

@Autowired
Backstage backstage;
@RequestMapping("/selectAllUsers")//查找所有用户
  public List<Usersafe> selectAll(){
return backstage.selectAllUsers();
}
@RequestMapping("/selectUserById")//通过user Id查找
  public Usersafe selectUserById(int userId){
  return backstage.selectUserById(userId);
}
@RequestMapping("/selectUserByName")//通过userName查找
  public Usersafe selectUserByName(String userName)
{
  return  backstage.selectUserByName(userName);
}
@RequestMapping("/blockAcccount")//锁定账户
  public int blockAcccount(int userId)
{
  return backstage.blockAcccount(userId);

}
  @RequestMapping("/countBlog")//总文章数
  public int countBlog(){
     return backstage.countBlog();
  }

//总人数
@RequestMapping("/countUser")
public  int countUser(){
    return backstage.countUser();
}




}