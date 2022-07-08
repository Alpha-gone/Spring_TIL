package com.example.ch2.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// 필터를 적용할 요청의 패턴 지정 - 모든 요청에 필터를 적용.
@WebFilter(urlPatterns = "/*")
public class PerformanceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1. 전처리 작업
        long startTime = System.currentTimeMillis();

        // 2. 서블릿 또는 다음 필터를 호출
        chain.doFilter(request, response);

        // 3. 후처리 작업
        System.out.print("["+((HttpServletRequest)request).getRequestURI()+"]");
        System.out.println(" 소요시간="+(System.currentTimeMillis()-startTime)+"ms");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
