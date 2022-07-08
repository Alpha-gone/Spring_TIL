package com.example.ch2.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspReturn {
    @RequestMapping("/twoDice")
    public String twoDice(){
        return "twoDice";
    }

    @RequestMapping("/el")
    public String el(){
        return "el";
    }

    @RequestMapping("/jstl")
    public String jst(){
        return "jstl";
    }
}
