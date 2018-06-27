package com.example.springbootmybatis.service;


import com.example.springbootmybatis.dao.UserDao;
import com.example.springbootmybatis.dto.AuthResult;
import com.example.springbootmybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserDao userDao;

    public AuthResult auth(String userName, String password) {
        try {
            if (userName == null || password == null) {
                return AuthResult.PASS_ERROR;
            }
            User user = userDao.getUserByName(userName);
            if (user == null) {
                return AuthResult.USER_NOT_FOUND;
            }
//            String pwdDigest = RealmBase.Digest(password, "SHA", null);
//            if (pwdDigest.equals(user.getPassword())) {
            if (password.equals(user.getPassword())) {
                return AuthResult.OK;
            } else {
                return AuthResult.PASS_ERROR;
            }
        }catch(Exception e){
            return AuthResult.SYSTEM_ERROR;
        }
    }
}
