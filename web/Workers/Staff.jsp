<%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 19.07.2017
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff Page</title>
</head>
<body>
<h2>Hello Employee</h2>
<%
    //HttpSession UserPage = request.getSession();
    String type = (String)session.getAttribute("UserType");
    if (type.equals("Employee")){
    }else{
        response.sendRedirect("http://localhost:8080/Project_Oscar_war_exploded/Unauthorized.jsp");
    }
%>

</body>
</html>
