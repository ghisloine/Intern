<%@ page import="java.io.PrintWriter" %>
<%@ page import="Sub.Data" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.NoSuchElementException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Sub.Yatch" %><%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 13.07.2017
  Time: 09:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false"  %>

<html>
<head>
    <title>Avalible Yatches</title>
</head>
<body>
<%
    String StartDate = request.getParameter("StartDate");
    String EndDate = request.getParameter("EndDate");
    Data data = new Data();
    Yatch yatch = new Yatch();
    data.baglanti();
    yatch.Yatches(data.LookingForYatch(StartDate,EndDate));
%>
<%
    PrintWriter pw = response.getWriter();
%>

</body>
</html>
