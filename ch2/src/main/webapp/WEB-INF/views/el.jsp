<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: alphagone
  Date: 2022-07-08 (008)
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.ch2.etc.*" %>
<%@ page import="com.example.ch2.dto.Person" %>

<%
    Person person = new Person();
    request.setAttribute("person", person);
    request.setAttribute("name", "남궁성");
    request.setAttribute("list", new ArrayList<>());
%>
<html>
<head>
    <title>EL</title>
</head>
<body>
    person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
    person.getCar().getColor()=${person.getCar().getColor()} <br>
    person.getCar().getColor()=${person.car.color} <br>
    name=<%=request.getAttribute("name")%> <br>
    name=${requestScope.name} <br>
    name=${name} <br>
    id=<%=request.getParameter("id")%> <br>
    id=${pageContext.request.getParameter("id")} <br>
    id=${param.id} <br>
    "1"+1 = ${"1"+1} <br>
    "1"+="1" = ${"1"+="1"} <br>
    "2">1 = ${"2">1} <br>
    null = ${null}<br>
    null+1 = ${null+1} <br>
    null+null = ${null+null} <br>
    "" + null = ${""+null} <br>
    ""-1 = ${""-1} <br>
    empty null=${empty null} <br>
    empty list=${empty list} <br>
    null==0 = ${null==0} <br>
    null eq 0 = ${null eq 0} <br>
    name == "남궁성"=${name=="남궁성"} <br>
    name != "남궁성"=${name!="남궁성"} <br>
    name eq "남궁성"=${name eq "남궁성"} <br>
    name ne "남궁성"=${name ne "남궁성"} <br>
    name.equals("남궁성")=${name.equals("남궁성")} <br>
</body>
</html>
