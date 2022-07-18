package com.example.ch3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.ch3.controller")
public class Ch3Application {

    public static void main(String[] args) {

        SpringApplication.run(Ch3Application.class, args);

    }

}
