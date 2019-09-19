package com.ndsc.blog.mapper;

import com.ndsc.blog.entity.Usersafe;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersafeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Usersafe record);

    int insertSelective(Usersafe record);

    Usersafe selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Usersafe record);

    int updateByPrimaryKey(Usersafe record);

    int becomeVip(Integer userId);

    int sameTel(String userTel);

    int sameName(String userName);

    int sameEmail(String userEmail);

    String selectByUserName(String userinput, String userPassword);

    String selectByUserTel(String userinput, String userPassword);

    String selectByUserEmail(String userinput, String userPassword);
    String selectuserTel(String userTel);
    List<Usersafe> selectAllUsers();
    Usersafe selectUserById(int userId);
    Usersafe selectUserByName(String userName);
    int blockAcccount(int userId);
    int countBlog();
    int countUser();
    int countVip();
    Integer selectUserId(String userName);

    //*********************************
    int updateUsersafe(Usersafe usersafe);

    Usersafe selectUidUsafeUinfoBlog(Integer userId);

    Usersafe selectUnameUsafeUinfoBlog(String userName);
}