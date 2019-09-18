package com.ndsc.blog.controller;

import com.ndsc.blog.entity.Usersafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Backstage {

@Autowired Backstage backstage;
@RequestMapping("/selectAllUsers")
  public   Usersafe selectAll(){
return backstage.selectAll();
}

}

