package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 2017/12/21.
 */
@Mapper
@Repository
public interface UserDao {
    User getUserByName(@Param("userName") String userName);
    User getUserByID(@Param("userID") String userID);
    //获取所有用户表
    List<User> findAllUser();
    //查询用户
    List<User> queryUser(@Param("userName") String userName);
    //修改密码
    public void updatePwd(@Param("userId") String userId, @Param("password") String password);
    //修改用户信息
    public void updateInfo(@Param("userId") String userId, @Param("userNickName") String userNickName, @Param("sex") String sex, @Param("userEmail") String userEmail, @Param("userPhone") String userPhone);
    //添加用户
    public void addUser(@Param("userName") String userName, @Param("userNickName") String userNickName, @Param("userPhone") String userPhone, @Param("userRole") String userRole, @Param("pwd") String pwd);
    //修改权限
    public void updateUserRole(@Param("userId") String userId, @Param("role") String role);
    //删除用户
    public void deleteUser(@Param("userId") String userId);
}
