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
@RequestMapping("/selectAllUsers")
  public List<Usersafe> selectAll(){
return backstage.selectAllUsers();
}
@RequestMapping("/selectUserById")
  public Usersafe selectUserById(int userId){
  return backstage.selectUserById(userId);
}
@RequestMapping("/selectUserByName")
  public Usersafe selectUserByName(String userName)
{
  return  backstage.selectUserByName(userName);
}
@RequestMapping("/blockAcccount")
  public int blockAcccount(int userId)
{
  return backstage.blockAcccount(userId);

}
  @RequestMapping("/countBlog")
  public int countBlog(){
     return backstage.countBlog();
  }
}

