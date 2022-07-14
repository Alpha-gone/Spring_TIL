package com.example.ch2.registerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLController {
    @RequestMapping("/registerForm")
    public String registerForm(){
        return "registerForm";
    }

    @RequestMapping("/registerInfo")
    public String registerInfo(){
        return "registerInfo";
    }
}
