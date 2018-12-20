
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>
<jsp:useBean id="sess_news" class="pl.bskopinski.javaee.kolokwium2.domain.Camera" scope="session" />

<h1>Nazwa ${sess_news.name} </h1>
<p>Data produkcji ${sess_news.date}  </p>
<p> Kolor: (${sess_news.color})</p>
<p>Wybrane dodatki: ${sess_news.extras}</p>


</body>
</html>
