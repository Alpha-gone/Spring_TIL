package com.example.ch2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Controller
public class RequestHeader {

    @RequestMapping("/requestHeader")
    public void printHeaders(HttpServletRequest request){
        Iterator<String> headerNames = request.getHeaderNames().asIterator();

        while (headerNames.hasNext()){
            String name = headerNames.next();
            System.out.println(name + " : " + request.getHeader(name));
        }
    }

    @RequestMapping("/requestMessage")
    public void printHeaderMessage(HttpServletRequest request) throws IOException {
        StringBuilder requestLine = new StringBuilder(request.getMethod());
        requestLine.append(" " + request.getRequestURI() + "\n");

        String queryString = request.getQueryString();
        requestLine.append(queryString == null ? "" : queryString);
        requestLine.append(" " + request.getProtocol()+ "\n");
        System.out.println(requestLine);

        Iterator<String> headerNames = request.getHeaderNames().asIterator();
        headerNames.forEachRemaining(name -> System.out.println(name + ":" + request.getHeader(name)));

        final int CONTENT_LENGTH = request.getContentLength();
        System.out.println("content length = " + CONTENT_LENGTH);

        if(CONTENT_LENGTH > 0){
            byte[] content = new byte[CONTENT_LENGTH];

            InputStream in = request.getInputStream();
            in.read(content, 0, CONTENT_LENGTH);

            System.out.println();
            System.out.println(new String(content, "utf-8"));
        }
    }
}

