<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Newsletter</title>
</head>
<body>

<h1>Witamy w sklepie apartow:</h1>
<form action="add-camera">
    <label for="name">Nazwa:</label>
    <input type="text" name="name" id="name" required="required"><br>

    <label for="date">Data Produkcji:</label>
    <input type="text" name="date" id="date" required="required" ><br>


    <br><label>color:</label><br>
    <input type="radio" name="color" value="niebieski">niebieski<br>
    <input type="radio" name="color" value="zielony">zielony<br>
    <input type="radio" name="color" value="czerwony">czerwony<br>

    <br><label >Dodatki</label><br>
    <input type="checkbox" name="extras" value="torba">torba<br>
    <input type="checkbox" name="extras" value="stojak">stojak<br>
    <input type="checkbox" name="extras" value="ekran">ekran<br><br>

    <input type="submit" value="dodaj">
</form>

</body>
</html>