package com.example.springbootmybatis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyWebServerConfigurationProperties.class)
public class MyWebServerConfiguration {
    @Autowired
    private MyWebServerConfigurationProperties properties;
    /**
     *下面就可以引用MyWebServerConfigurationProperties类       里的配置了
     */
    public void setMyconfig() {
        int port = properties.getPort();
        System.out.println(port);
        // ...........
    }
}
