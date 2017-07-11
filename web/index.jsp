<%@ page import="Sub.Data" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 11.07.2017
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Data data = new Data();
    PrintWriter pw = response.getWriter();
    pw.println(data.UserList());
  %>
  </body>
</html>
