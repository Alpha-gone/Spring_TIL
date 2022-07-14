package com.example.ch2.exceptionController;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String catcher(Exception e){
        return "error";
    }

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception e, Model model){
        model.addAttribute("ex", e);

        return "error";
    }

    @RequestMapping("/ex")
    public String main() throws Exception {
        throw new Exception("예외가 발생했습니다.");
    }

    @RequestMapping("/ex2")
    public String main2() throws Exception {
        throw new NullPointerException("예외가 발생했습니다.");
    }
}