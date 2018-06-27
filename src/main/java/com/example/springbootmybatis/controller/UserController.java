package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.AuthResult;
import com.example.springbootmybatis.exception.AossRestException;
import com.example.springbootmybatis.model.User;
import com.example.springbootmybatis.service.AuthService;
import com.example.springbootmybatis.service.UserService;
import com.example.springbootmybatis.utils.ResponseResult;
import com.example.springbootmybatis.utils.ResultStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam String userID, @RequestParam String password) throws Exception {
        AuthResult result = authService.auth(userID, password);
        if(result.equals(AuthResult.OK)){
            return mapper.writeValueAsString(new ResponseResult());
        }else{
            return mapper.writeValueAsString(new ResponseResult(ResultStatus.FAILED,result.getTips()));
        }
    }

    //登陆界面重置密码
    @RequestMapping(value = "/resetPwdLogin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String resetPwdLogin(@RequestParam String userName, @RequestParam String userNickName, @RequestParam String userEmail, @RequestParam String userPhone) throws AossRestException {
        try {
            userService.resetPwdLogin(userName, userNickName,  userEmail, userPhone);
            return mapper.writeValueAsString(new ResponseResult());
        }catch (IOException e){
            throw new AossRestException("返回数据失败，请重试",e);
        } catch (Exception e){
            throw new AossRestException(e);
        }
    }

    //修改个人信息
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateInfo(@RequestParam String userId, @RequestParam String userNickName, @RequestParam String sex,
                             @RequestParam String userEmail, @RequestParam String userPhone) throws AossRestException{
        try {
            userService.updateInfo(userId,userNickName,sex,userEmail,userPhone);
            return mapper.writeValueAsString(new ResponseResult());
        }catch (IOException e){
            throw new AossRestException("返回数据失败，请重试",e);
        } catch (Exception e){
            throw new AossRestException(e);
        }
    }

    //修改密码
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updatePwd(@RequestParam String userId, @RequestParam String password) throws AossRestException{
        try {
            userService.updatePwd(userId,password);
            return mapper.writeValueAsString(new ResponseResult());
        }catch (IOException e){
            throw new AossRestException("返回数据失败，请重试",e);
        } catch (Exception e){
            throw new AossRestException(e);
        }
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findallUser() throws Exception {
        List<User> result = userService.findAllUser();
        return mapper.writeValueAsString(new ResponseResult<List<User>>(result));
    }

    @RequestMapping(value = "/findone", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findone(@RequestParam String userName) throws Exception {
        User user = userService.findeOneUser(userName);
        return mapper.writeValueAsString(new ResponseResult<User>(user));
    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryUser(@RequestParam("userName") String userName) throws Exception {
        List<User> result = userService.queryUser(userName);
        return mapper.writeValueAsString(new ResponseResult<List<User>>(result));
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addUser(@RequestParam String userName, @RequestParam String userNickName, @RequestParam String userPhone, @RequestParam String userRole) throws AossRestException{
        try {
            userService.hasUser(userName);
            userService.addUser(userName, userNickName, userPhone, userRole, "123456");
            return mapper.writeValueAsString(new ResponseResult());
        }catch (IOException e){
        throw new AossRestException("添加失败，请重试!",e);
        }catch (Exception e){
            throw new AossRestException(e);
        }
    }

    @RequestMapping(value = "/updateUserRole", method = RequestMethod.GET , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateUserRole(@RequestParam String userID , @RequestParam String userRole)throws Exception {
        userService.updateUserRole(userID,userRole);
        return mapper.writeValueAsString(new ResponseResult());
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET ,produces = "text/html;charset=UTF-8" )
    @ResponseBody
    public String deleteUser(@RequestParam String userId) throws Exception {
        userService.deleteUser(userId);
        return mapper.writeValueAsString(new ResponseResult());
    }

}