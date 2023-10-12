<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<c:url var="edit_url" value="/rest/edit"/>
<form:form method="post" modelAttribute="restaurant" action="${edit_url}">

    <form:hidden path="id"/>
    Wpisz nazwę restauracji: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Wpisz adres restauracji: <form:input path="address"/>
    <form:errors path="address"/><br/>
    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>

