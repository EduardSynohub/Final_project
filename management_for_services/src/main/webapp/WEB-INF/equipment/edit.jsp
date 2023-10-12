<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Modyfikacja sprzętu</title>
</head>
<body>
<c:url var="edit_url" value="/equip/edit"/>
<form:form method="post" modelAttribute="equipment" action="${edit_url}">

    <form:hidden path="id"/>
    Wpisz nazwę sprzętu: <form:input path="name"/>
    <form:errors path="name"/><br/>
    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>

