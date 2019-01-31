<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 31.01.19
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
Witaj <%= session.getAttribute("user_name") %> </br><ul><li><a href='/servletjspdemo/AddAirCondtioner.jsp'>Add Air Condtioner</a></li>
    <li><a href='/servletjspdemo/AllAirConditioners'> Show All Condtioners</a></li>
    <li><a href='/servletjspdemo/Cart'> Show Cart</a></li></ul>
</body>
</html>
