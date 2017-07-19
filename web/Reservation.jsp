<%@ page import="java.io.PrintWriter" %>
<%@ page import="Sub.Update" %>
<%@ page import="Sub.Data" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer" %><%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 18.07.2017
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
<%
    Update update = new Update();
    String[]Chose= request.getParameterValues("anahtar");
    session.setAttribute("Yatches",Chose);
    String Baslangic = (String) session.getAttribute("StartDate");

%>
<h1>For Reservation Please Enter Your Info</h1>
<form action="Register.jsp" method="post">
    <fieldset>
        <legend>Personal Information</legend>
    EndDestination:<br>
    <input type="text" name="EndDestination"><br>
    TcKimlikNo:<br>
    <input type="text" name="TCKNumber"><br>
    Captain_TCK:<br>
    <input type="text" name="CAP_TCKno" ><br>
    <input type="submit" name = "Submittion">
    </fieldset>
</form>


</body>
</html>