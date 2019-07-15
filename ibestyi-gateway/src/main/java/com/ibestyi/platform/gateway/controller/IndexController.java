package com.ibestyi.platform.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${info.app.name}")
    private String appName;

    @Value("${server.port}")
    private String appPort;

    @RequestMapping("/")
    public String index(){
        return "欢迎访问"+appName+"，服务端口："+appPort;

    }
}
