package com.example.ch2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch2")
public class HelloController {
    int iv = 10;
    static int cv = 20;

    @RequestMapping("/hello")
    public String main(){ //인스턴스 메서드 - iv, cv를 둘다 사용 가능
        System.out.println("Hello");

        return "Hello";
    }
}
