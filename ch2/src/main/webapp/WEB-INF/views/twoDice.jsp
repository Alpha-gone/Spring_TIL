<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: alphagone
  Date: 2022-07-07 (007)
  Time: 오후 6:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%! 클래스 영역 %> --%>
<%!
    int getRandomInt(int range){
        return new Random().nextInt(range) + 1;
    }
%>
<%-- <%  메서드 영역 - service()의 내부 %> --%>
<%
    int idx1 = getRandomInt(6);
    int idx2 = getRandomInt(6);
%>
<html>
<head>
    <title>twoDice.jsp</title>
</head>
<body>
    <img src="img/dice<%=idx1%>.jpg">
    <img src="img/dice<%=idx2%>.jpg">
</body>
</html>
