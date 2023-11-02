<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Serwis do zgłoszeń</title>
    <meta charset="utf-8" lang="pl">
</head>
<body>

<%@include file="header.jsp"%>

<a href="/user/all">Wszystkie użytkowniki</a><br>

<a href="/problem/all">Wszystkie zgłoszenia</a><br>
<a href="/problem/create">Dodaj zgłoszenie</a><br>

<a href="<c:url value="/"/> ">Na stronę główną</a>

<%@include file="footer.jsp"%>

</body>
</html>
