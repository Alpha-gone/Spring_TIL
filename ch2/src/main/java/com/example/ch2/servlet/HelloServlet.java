package com.example.ch2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //서블릿이 초기화될때 자동 호출되는 메서드
        System.out.println("[HelloServlet] init() is called.");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //입력
        //처리
        //출력
        System.out.println("[HelloServlet] service() is called.");
    }

    @Override
    public void destroy() {
        //서블릿이 메모리에서 제거될때 서블릿 컨테이너에서 자동으로 호출
        System.out.println("[HelloServlet] destroy() is called.");
    }


}
