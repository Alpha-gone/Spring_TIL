package com.example.ch2.mvc;

import com.example.ch2.dto.MyDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTellerMVC5 {
    
    @ExceptionHandler(Exception.class)
    public String catcher(Exception exception){
        exception.printStackTrace();
        return "yoilError";
    }

    @RequestMapping("/getYoilMVC5")
    public String main(@ModelAttribute MyDate date,
                       Model model) throws IOException {

        if(!isValid(date)){
            return "yoilError";
        }
        return "yoil";
    }

    private boolean isValid(MyDate date){
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }

    private boolean isValid(int year, int month, int day) {
        if(year==-1 || month==-1 || day==-1)
            return false;

        return (1<=month && month<=12) && (1<=day && day<=31);
    }

    private @ModelAttribute("yoil") char getYoil(MyDate date){
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
