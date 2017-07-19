<%@ page import="Sub.Data" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 19.07.2017
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log-in or OUT</title>
</head>
<body>
<%
    String KullanıcıAdi = request.getParameter("Username");//Burası Okey
    String KullanıcıParola = request.getParameter("Password");//Burası Okey
%>

<%
    String Username;
    String Password;
    String Autho;
    Data data = new Data();
    Statement statement = null;
    if (KullanıcıAdi != null && KullanıcıParola.length()>0) {
        try {
            statement = data.baglanti().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                Username = resultSet.getString("Username");
                Password = resultSet.getString("Password");
                Autho = resultSet.getString("Authority");
                if (KullanıcıAdi.equalsIgnoreCase(Username) && Password.equals(KullanıcıParola)) {
                    out.println("Basarılı Giris Yaptınız<br>");
                    out.println("Anasayfaya yönlendiriliyorsunuz Sayın:" + KullanıcıAdi + "<br>");
                    //String url = "http://localhost:8080/Project_Oscar_war_exploded/index.jsp";
                    if (Autho.equals("Admin")){
                        response.sendRedirect("http://localhost:8080/Project_Oscar_war_exploded/Admin.jsp");
                        //HttpSession UserPage = request.getSession(true);
                        session.setAttribute("UserType",Autho);
                        break;
                    }else if (Autho.equals("Employee")){
                        response.sendRedirect("http://localhost:8080/Project_Oscar_war_exploded/Workers/Staff.jsp");
                        session.setAttribute("UserType",Autho);
                        break;
                    }else if (Autho.equals("Normal") || Autho.equals(null)){
                        //HttpSession UserPage = request.getSession(true);
                        session.setAttribute("UserType",Autho);
                        break;
                    }//response.sendRedirect(url);
                    break;
                } else {

                }
            }
            session.setAttribute("UserName", KullanıcıAdi);
            session.setAttribute("UserPass", KullanıcıParola);

        } catch (Exception e) {
            out.println(e);
        }
    }else{
        out.println("Parola Alanı Boş Kalamaz");
        out.println(
                "<form action = Login.jsp method = post>" +
                        "<input type = submit name = WrongLogin value = LoginEkranınaGeriDön>" +
                        "</form> "
        );
    }
%>

</body>
</html>
