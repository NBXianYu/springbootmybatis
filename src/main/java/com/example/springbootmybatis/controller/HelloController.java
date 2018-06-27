package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.exception.AossRestException;
import com.example.springbootmybatis.service.MyCodeMakerService;
import com.example.springbootmybatis.test.MyConfig;
import com.example.springbootmybatis.test.MyWebServerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class HelloController {
    @Autowired
    private MyConfig myConfig;
    @Autowired
    private MyWebServerConfiguration myWebServerConfiguration;
    @Autowired
    private MyCodeMakerService codeMakerService;

    @RequestMapping("/config")
    public Object getConfig() {
        myWebServerConfiguration.setMyconfig();
        return myConfig.getServers();
    }

    @RequestMapping("/codeMake")
    public String codeMake() throws Exception {
        codeMakerService.codeMake("bysj");
        return "ABDSDD";
    }
}
