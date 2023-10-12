<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edytowanie informacji o serwisie</title>
</head>
<body>
<c:url var="edit_url" value="/repair/edit"/>
<form:form method="post" modelAttribute="repair_service" action="${edit_url}">

    <form:hidden path="id"/>
    Wpisz nazwę serwisu: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Wpisz adres serwisu: <form:input path="address"/>
    <form:errors path="address"/><br/>
    Wpisz numer telefonu do serwisu: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/><br>
    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>

