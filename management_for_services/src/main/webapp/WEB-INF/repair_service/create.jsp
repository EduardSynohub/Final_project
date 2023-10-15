<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Dodawanie nowego serwisu</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<%--<c:url var="edit_url" value="/repair/edit/${repair_service.id}"/>--%>
<form:form method="post" modelAttribute="repair_service">
  <form:hidden path="id"/>
  Wpisz nazwę serwisu: <form:input path="name"/>
  <form:errors path="name"/><br/>
  Wpisz adres serwisu: <form:input path="address"/>
  <form:errors path="address"/><br/>
  Wpisz numer telefonu do serwisu: <form:input path="phoneNumber"/>
  <form:errors path="phoneNumber"/><br/>
  <input type="submit" value="Dodaj">
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>