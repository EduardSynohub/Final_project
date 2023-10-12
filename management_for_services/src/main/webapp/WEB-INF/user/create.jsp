<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Rejestracja</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<c:url var="edit_url" value="/user/edit/${user.id}"/>
<form:form method="post" modelAttribute="user" action="${edit_url}">
  <form:hidden path="id"/>
  Wpisz imię: <form:input path="name"/>
  <form:errors path="name"/><br/>
  Wpisz nazwisko: <form:input path="surname"/>
  <form:errors path="surname"/><br/>
  Wpisz email: <form:input path="email"/>
  <form:errors path="email"/><br/>
  Wpisz hasło: <form:password path="password"/>
  <form:errors path="password"/><br/>
  Wpisz swoje stanowisko: <form:input path="jobTitle"/>
  <form:errors path="jobTitle"/><br/>
  Wybierz restauracje: <form:select path="restaurant.id" items="${list_of_restaurant}" itemValue="id" itemLabel="name" />
  <form:errors path="restaurant"/><br/>
  <input type="submit" value="Rejestracja">
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
