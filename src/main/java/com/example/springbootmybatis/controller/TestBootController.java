package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestBootController {
    @RequestMapping("/user")
    @ResponseBody
    public String getUser() {
        return "Hello pengge !";
    }
}