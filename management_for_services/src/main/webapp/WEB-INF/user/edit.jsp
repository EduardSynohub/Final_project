<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<c:url var="edit_url" value="/user/edit"/>
<form:form method="post" modelAttribute="user" action="${edit_url}">

    <form:hidden path="id"/>
    Wpisz imię: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Wpisz nazwisko: <form:input path="surname"/>
    <form:errors path="surname"/><br/>
    Wpisz swoje stanowisko: <form:input path="jobTitle"/>
    <form:errors path="jobTitle"/><br/>
    Wybierz restauracje: <form:select path="restaurant.id" items="${list_of_restaurant}" itemValue="id" itemLabel="name" />
    <form:errors path="restaurant"/><br/>
    <input type="submit" value="Edit">
</form:form>

</body>
</html>

