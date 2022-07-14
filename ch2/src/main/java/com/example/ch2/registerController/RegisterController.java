package com.example.ch2.registerController;

import com.example.ch2.dto.User;
import com.example.ch2.validator.GlobalValidator;
import com.example.ch2.validator.UserValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @InitBinder
    public void toDate(WebDataBinder binder){
        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));*/
        binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
        binder.setValidator(new UserValidator());
        //binder.addValidators(new UserValidator());
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String register(){
        return "registerForm";
    }

    @PostMapping("/save")
    public String save(@Validated User user, BindingResult result, Model model) throws UnsupportedEncodingException {
        System.out.println("result = " + result);
        System.out.println("user = " + user);

        /*UserValidator userValidator = new UserValidator();
        userValidator.validate(user, result);*/


        if(result.hasErrors()){
            return "registerForm";
        }

        /*if (!isValid(user)){
            String msg = URLEncoder.encode( "id를 잘못입력","utf-8");

            model.addAttribute("msg", msg);
            return "forward:/register/add";
            //return "redirect:/register/add?msg=" + msg;
        }*/

        return "registerInfo";
    }

    private boolean isValid(User user) {
        return true;
    }

}
