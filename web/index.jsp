<%@ page import="Sub.Data" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="javax.swing.plaf.nimbus.State" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 11.07.2017
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Main Page</title>
  </head>
<body><h3>Hoşgeldiniz <%=session.getAttribute("UserName")
%></h3>
------------------------------------
<h2>Rezervasyon İçin Tarih Seçin</h2>
  <form action="/Exception.jsp" method="post"></form>
    <table width="500" border="1">
      <form action="/Project_Oscar_war_exploded/Exception.jsp" method="post" id="index" name = "index">
        Start Date:<br>
        <input type="date" name="StartDate" value="StartDate"><br>
        End Date:<br>
        <input type="date" name="EndDate" value="EndDate"><br><br>
        <input type="submit" value="Submit" name="gonder">
      </form>
      <%
        String startDate = request.getParameter("StartDate");
        Data data = new Data();
        PrintWriter pw = response.getWriter();
        data.baglanti();
        pw.println(startDate);
      %>
    </table>
    </form>
<br>
<br>
<form action="Login.jsp" method="post">
  <legend>Login Olmak İçin Tıklayın</legend><br>
  <br>
  <input type="submit" name="sendLoginPage" value="Login">
</form>
<form action="LogOut.jsp" method="post">
<legend>Çıkış için</legend><br>
<input type="submit" name="logout">
</form>
</body>
</html>
