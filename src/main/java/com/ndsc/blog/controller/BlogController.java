package com.ndsc.blog.controller;

import com.ndsc.blog.entity.*;
import com.ndsc.blog.mapper.UsersafeMapper;
import com.ndsc.blog.service.BlogService;
import com.ndsc.blog.service.Md5Encryption;
import com.ndsc.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    Md5Encryption md5Encryption;

    @Autowired
    UsersafeMapper usersafeMapper;
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/getUserinfo")
    public Userinfo getUserinfo(int userId) {
        return blogService.selectUserId(userId);
    }

    @RequestMapping("/getUserinfo1")
    public Userinfo getUserinfo(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int userId = usersafeMapper.selectUserId(userName);
        System.out.println(userId);
        return blogService.selectUserId(userId);
    }

    @RequestMapping("/updateUserinfo")
    public String updateUserinfo(Userinfo userinfo, HttpServletRequest request) {
        //获取id
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int id = usersafeMapper.selectUserId(userName);
        //获取原有的userInfo
        Userinfo newUserInfo = userInfoService.selectByUserId(id);
        //修改userInfo
        newUserInfo.setUserSex(userinfo.getUserSex());
        newUserInfo.setRealName(userinfo.getRealName());
        newUserInfo.setUserBirthday(userinfo.getUserBirthday());
        blogService.updateUserinfo(newUserInfo);
        return "<a id=\"ak\" href='userinfoindex.html'>跳转</a>\n" +
                "<script>\n" +
                "    document.getElementById(\"ak\").click();\n" +
                "</script>";
    }

    @RequestMapping("/addRelation")
    public int addRelation(@RequestBody Relation relation) {
        return blogService.insertRelation(relation);
    }

    @RequestMapping("/getRelationUserinfo")
    public List<Userinfo> getRelationUserinfo(int fansId) {
        return blogService.selectRelationUser(fansId);
    }

    @RequestMapping("/getMyRelationUserinfo")
    public List<Userinfo> getMyRelationUserinfo(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int userId = usersafeMapper.selectUserId(userName);
        return blogService.selectRelationUser(userId);
    }

    @RequestMapping("/removeRelation")
    public int removeRelation(Relation relation) {
        return blogService.deleteRelation(relation);
    }


    @RequestMapping("/getFans")
    public List<Userinfo> getFans(int blogerId) {
        return blogService.selectFans(blogerId);
    }

    @RequestMapping("/getMyFans")//获得当前登录用户的粉丝
    public List<Userinfo> getMyFans(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int userId = usersafeMapper.selectUserId(userName);
        return blogService.selectFans(userId);
    }

    @RequestMapping("/updateUsersafe")
    public int updateUsersafe(@RequestBody Usersafe usersafe) {
        usersafe.setPassword(md5Encryption.encrype(usersafe.getPassword()));
        return blogService.updateUsersafe(usersafe);
    }

    @RequestMapping("/selectByUserinfoGetBlog")
    public Userinfo selectByUserinfoGetBlog(int userId) {
        Userinfo userinfo = blogService.selectByUserinfoGetBlog(userId);
        return userinfo;
    }

    @RequestMapping("/selectByBlogtagGetBlog")
    public List<Blog> selectByBlogtagGetBlog(String tagName) {
        return blogService.selectByBlogtagGetBlog(tagName);
    }

    @RequestMapping("/insertCollection")
    public int insertCollection(@RequestBody Collect collection) {
        return blogService.insertCollection(collection);
    }

    @RequestMapping("/selectCollectionBlog")
    public List<Blog> selectCollectionBlog(Integer collectionId) {
        return blogService.selectCollectionBlog(collectionId);
    }

    @RequestMapping("/selectCollectionBlog1")
    public List<Blog> selectCollectionBlog1(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int userId = usersafeMapper.selectUserId(userName);
        return blogService.selectCollectionBlog(userId);
    }

    @RequestMapping("/deleteCollection")
    public int deleteCollection(@RequestBody Collect collection) {
        return blogService.deleteCollection(collection);
    }

    @RequestMapping("/selectFansCount")
    public int selectFansCount(Integer blogerId) {
        return blogService.selectFansCount(blogerId);
    }

    @RequestMapping("/selectFansCount1")
    public int selectFansCount1(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int blogerId = usersafeMapper.selectUserId(userName);
        System.out.println(blogerId);
        return blogService.selectFansCount(blogerId);
    }

    @RequestMapping("/selectBlogerCount")
    public int selectBlogerCount(Integer fansId) {
        return blogService.selectBlogerCount(fansId);
    }

    @RequestMapping("/selectBlogerCount1")
    public int selectBlogerCount1(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int fansId = usersafeMapper.selectUserId(userName);
        System.out.println(fansId);
        return blogService.selectBlogerCount(fansId);
    }

    @RequestMapping("/selectCollectionCount")
    public int selectCollectionCount(Integer collectionId) {
        return blogService.selectCollectionCount(collectionId);
    }

    @RequestMapping("/selectCollectionCount1")
    public int selectCollectionCount1(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        int collectionId = usersafeMapper.selectUserId(userName);
        System.out.println(collectionId);
        return blogService.selectCollectionCount(collectionId);
    }

    @RequestMapping("/selectUidUsafeUinfoBlog")
    public Usersafe selectUidUsafeUinfoBlog(Integer userId) {
        return blogService.selectUidUsafeUinfoBlog(userId);
    }

    @RequestMapping("/selectUnameUsafeUinfoBlog")
    public Usersafe selectUnameUsafeUinfoBlog(String userName) {
        return blogService.selectUnameUsafeUinfoBlog(userName);
    }
}
