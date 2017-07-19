<%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 19.07.2017
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unauthorized</title>
</head>
<body>
<h1>Nice Try But Not Good Enought</h1>
<%String type = (String)session.getAttribute("UserType");
    out.println("<h2>"+type+"</h2>");
%>
</body>
</html>
