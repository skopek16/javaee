<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 15.11.18
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newsletter</title>
</head>
<body>
Imie: <input type='text' name='name' /> <br/>

Od: <input type='text' name='dataOd' />  Do: <input type='text' name='dataDo' /> <br/>


<div>
    <input type="radio" id="dziennie" name="drone" value="dziennie"
           checked>
    <label for="dziennie">dziennie</label>
</div>

<div>
    <input type="radio" id="tygodniowo" name="drone" value="tygodniowo">
    <label for="tygodniowo">tygodniowo</label>
</div>

<div>
    <input type="radio" id="miesiecznie" name="drone" value="miesiecznie">
    <label for="miesiecznie">miesiecznie</label>
</div>

<label for="historiaKlimatyzatorow">historia klimatyzatorow:</label>
<input type="checkbox" name="historiaKlimatyzatorow" id="historiaKlimatyzatorow" ><br>

<label for="noweKlimatyzatory">nowe klimatyzatory:</label>
<input type="checkbox" name="noweKlimatyzatory" id="noweKlimatyzatory" ><br>

<input type="submit" value="save">
</body>
</html>
