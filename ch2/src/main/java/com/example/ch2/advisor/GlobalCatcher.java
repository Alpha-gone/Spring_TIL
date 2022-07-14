package com.example.ch2.advisor;

import com.example.ch2.dto.User;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

@ControllerAdvice("com.example.ch2")
public class GlobalCatcher {
    @ExceptionHandler(Exception.class)
    public String catcher(Exception e, Model model){
        model.addAttribute("ex", e);

        return "error";
    }

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception e, Model model){
        model.addAttribute("ex", e);

        return "error";
    }

    @Validated
    public void validate(Object target, Errors errors) {
        System.out.println("GlobalValidator.validate() is called");

        User user = (User) target;
        String id = user.getId();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");

        if(id == null || id.length() < 5 || id.length() > 12){
            errors.rejectValue("id", "invalidLength", new String[]{"5", "12"}, null);
        }
    }
}
