<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Dodawanie zgłoszenia</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<form:form method="post" modelAttribute="breakdown" action="${edit_url}">
  <form:hidden path="id"/>
  Opisz problem: <form:input path="description"/>
  <form:errors path="description"/><br/>
  Data zgłoszenia: <form:input type="date" path="dateOfNotification"/>
  <form:errors path="dateOfNotification"/><br/>
  Data przyjazdu serwisanta: <form:input type="date" path="dateOfArrival"/>
  <form:errors path="dateOfArrival"/><br/>
  Wybierz sprzęt: <form:select path="equipment.id" items="${list_of_equipments}" itemValue="id" itemLabel="name" />
  <form:errors path="equipment"/><br/>
  Wybierz serwis: <form:select path="repairService.id" items="${list_of_repair_services}" itemValue="id" itemLabel="name" />
  <input type="submit" value="Zapisz">
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
