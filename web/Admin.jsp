<%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 19.07.2017
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration</title>
</head>
<body>
<h2>Hello Architect</h2>
<%
    //HttpSession UserPage = request.getSession();
    String type = (String)session.getAttribute("UserType");
    if (type.equals("Admin") ){
    }else{
        response.sendRedirect("http://localhost:8080/Project_Oscar_war_exploded/Unauthorized.jsp");
    }
%>
<h3>For Adding Yatch Owner Please Enter</h3><br>
<br>
<h3>For Adding User Please Enter</h3><<br>
<br>


</body>
</html>
