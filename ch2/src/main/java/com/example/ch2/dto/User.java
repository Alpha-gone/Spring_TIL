package com.example.ch2.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;

@Data
public class User {
    private String id;
    private String pwd;
    private String name;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String[] hobby;
    private String[] sns;


}
