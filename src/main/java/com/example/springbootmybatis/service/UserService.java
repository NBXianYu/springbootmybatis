package com.example.springbootmybatis.service;


import com.example.springbootmybatis.dao.UserDao;
import com.example.springbootmybatis.model.User;
import com.example.springbootmybatis.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2017/12/21.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    /**
     * 用户登录
     */
    public String login(String userID, String password) throws Exception {
        ResponseResult result = new ResponseResult();
        return  null;

    }
    /**
    * 查询所有用户
    */
    public List<User> findAllUser() throws Exception {

        List<User> userList = userDao.findAllUser();

        return userList;
    }
    public List<User> queryUser(String userName) throws Exception {

        List<User> userList = userDao.queryUser(userName);

        return userList;
    }


    public User getUserByID(String userID){

        return userDao.getUserByID(userID);
    }

    /**
     *根据用户登录名查询用户
     */
    public User findeOneUser(String userName) throws Exception {
        return userDao.getUserByName(userName);
    }

    public void resetPwdLogin(String userName, String userNickName, String userEmail, String userPhone) throws Exception {
        User user = userDao.getUserByName(userName);
        if(user == null){
            throw new Exception("用户未找到，请联系管理员!");
        }
        if(user.getNickName().equals(userNickName) && user.getEmail().equals(userEmail) && user.getPhone().equals(userPhone)){
            userDao.updatePwd(user.getUserID(),"123456");
        }else{
            throw new Exception("信息不服，请联系管理员！");
        }
    }

    /**
    * 更新用户密码
    */
    public void updatePwd(String userId, String password){
        userDao.updatePwd(userId,password);
    }

    /**
     * 更新用户信息
     */
    public void updateInfo(String userId, String userNickName, String sex, String userEmail, String userPhone){
        userDao.updateInfo(userId,userNickName,sex,userEmail,userPhone);
    }

    /**
     * 更新用户权限
     */
    public void updateUserRole(String userId, String role){
        userDao.updateUserRole(userId,role);
    }

    /**
    * 是否存在
    * */
    public boolean hasUser(String userName) throws Exception {
        User user = userDao.getUserByName(userName);
        if(user == null ){
            return false;
        }else{
            throw new Exception("此登陆名已经存在，请重新设置登录名");
        }
    }

    public void addUser(String userName, String userNickName, String userPhone, String userRole, String pwd) throws Exception {
        try{
            userDao.addUser(userName,userNickName,userPhone,userRole,pwd);
        }catch (Exception e){
            throw new Exception("添加失败，请重试!");
        }
    }

    /**
     * 删除用户
     * */
    public void deleteUser(String userId){
        userDao.deleteUser(userId);
    }

}
