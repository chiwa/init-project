package com.zengcode.controller;

import com.zengcode.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMainController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello World -->>  " + applicationProperties.getName();
    }
}
