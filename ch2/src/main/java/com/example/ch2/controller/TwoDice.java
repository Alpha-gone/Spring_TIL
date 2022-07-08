package com.example.ch2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@Controller
public class TwoDice {

    @RequestMapping("/rollDice")
    public void main(HttpServletResponse res) throws IOException {
        Random rnd = new Random();
        int idx1 = rnd.nextInt(1, 6);
        int idx2 = rnd.nextInt(1, 6);

        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");

        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='img/dice" + idx1 + ".jpg'>");
        out.println("<img src='img/dice" + idx2 + ".jpg'>");
        out.println("</body>");
        out.println("</html>");

    }
}
