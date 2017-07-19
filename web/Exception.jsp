<%@ page import="java.io.PrintWriter" %>
<%@ page import="Sub.Data" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="Sub.Yatch" %>
<%@ page import="java.util.*" %><%--
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
    session.setAttribute("StartDate",StartDate);
    session.setAttribute("EndDate",EndDate);
    Data data = new Data();
    Yatch yatch = new Yatch();
    data.baglanti();
    yatch.Yatches(data.LookingForYatch(StartDate,EndDate));
%>
<form action="Reservation.jsp" method="post">
<%
    PrintWriter pw = response.getWriter();
    for (Map.Entry<String,ArrayList<String>> entry : yatch.Yatches(data.LookingForYatch(StartDate,EndDate)).entrySet()){
        String key = entry.getKey();
        List<String>values = entry.getValue();
      %>
    <%=values%>
    <input type=checkbox name=anahtar value=<%=key%>>Choose ME!!<br>
    <%
    }
%>





<input type="submit" value="Sender" name="SubmitYatches">
</form>
</body>
</html>
