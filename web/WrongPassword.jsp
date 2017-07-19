<%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 19.07.2017
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Required</title>
</head>
<body>
<h3>Lütfen Parola Giriniz</h3>
<%
    String URL = "http://localhost:8080/Project_Oscar_war_exploded/Login.jsp";
    wait(4000);
    response.sendRedirect(URL);
%>

</body>
</html>
