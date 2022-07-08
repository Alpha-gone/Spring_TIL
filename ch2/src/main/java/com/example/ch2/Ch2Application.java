package com.example.ch2;

import com.example.ch2.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.lang.reflect.Method;

@ServletComponentScan
@SpringBootApplication
public class Ch2Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Ch2Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Ch2Application.class, args);

        /*HelloController helloController = new HelloController();
        helloController.main(); // private라서 외부 호출 불가능*/

        //Reflection API 를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공
        //java.lang.reflect 패키지를 제공
        //Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
        Class helloClass = Class.forName("com.example.ch2.controller.HelloController");
        HelloController helloController = (HelloController) helloClass.getDeclaredConstructor().newInstance(); //Class 객체가 가진 정보로 객체 생성

        Method main = helloClass.getDeclaredMethod("main");
        main.setAccessible(true); // private인 main()을 호출가능하게 한다.

        main.invoke(helloController);

    }


}
