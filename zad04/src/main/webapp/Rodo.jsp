<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 31.01.19
  Time: 03:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rodo form</title>
</head>
<body>
<form action="rodo-check">
    <p>If you want continue, accept privite policy.</p>
    <label for="firstName">First name:</label>
    <input type="text" name="firstName" id="firstName" required="required"><br>

    <label for="lastName">Last name:</label>
    <input type="text" name="lastName" id="lastName" required="required"><br>

    <label for="email">E-mail:</label>
    <input type="text" name="email" id="email" required="required"><br>

    <label for="rodo">I accept privacy policy:</label>
    <input type="checkbox" name="rodo" id="rodo" required="required"><br>

    <input type="submit" value="Send">
</form>
</body>
</html>

