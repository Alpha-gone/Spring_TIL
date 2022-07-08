    <%--
  Created by IntelliJ IDEA.
  User: alphagone
  Date: 2022-07-05 (005)
  Time: 오후 5:58
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        <title>Home</title>
        </head>
        <body>
                year = <%= request.getParameter("year") %>
                <p>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}입니다.</p>
        </body>
        </html>
