package com.shopping.dao;

import com.shopping.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer id);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(UserInfo record);

    /*根据用户名和旧密码修改密码*/
    int updateByUserNameAndPasswordOld(@Param("username") String username, @Param("passwordOld") String passwordOld, @Param("passwordNew") String passwordNew);

    /*根据用户名和旧密码修改密码*/
    int updateByID(UserInfo usr);

    /*
     * 根据用户名和密码查找用户*/
    UserInfo selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    List<UserInfo> selectAll();



    /*根据用户名查找用户*/
    int checkUser(String username);


    /*根据邮箱查找用户*/
    int checkEmail(String username);

    /*根据用户名查找用户*/
    UserInfo forgetUserName(String username);

    /*
     * 根据用户名、密码问题、问题答案查找用户*/
    int selectByUserNameAndQuestionAndAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    /*根据用户名修改密码*/
    int updateByUserName(@Param("username") String username, @Param("passwordNew") String passwordNew);

    int insert(UserInfo record);
}