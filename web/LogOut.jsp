<%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 19.07.2017
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log Out</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("http://localhost:8080/Project_Oscar_war_exploded/index.jsp");
%>

</body>
</html>
