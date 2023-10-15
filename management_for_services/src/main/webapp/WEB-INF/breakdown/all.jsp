<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie awarię</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<table border="3">
  <thead>
  <th>Nazwa sprzętu</th>
  <th>Opis awarii</th>
  <th>Serwis</th>
  <th>Data zgłoszenia</th>
  <th>Data przyjazdu serwisanta</th>
  <th>Akcja</th>
  </thead>
  <tbody>
  <c:forEach items="${breakdowns}" var="breakdown">
    <tr>
      <td><c:out value="${breakdown.equipment.name}"/></td>
      <td><c:out value="${breakdown.description}"/></td>
      <td><c:out value="${breakdown.repairService.name}"/></td>
      <td><c:out value="${breakdown.dateOfNotification}"/></td>
      <td><c:out value="${breakdown.dateOfArrival}"/></td>
      <td>
        <a href="<c:out value="/problem/delete/${breakdown.id}"/>">Usuń</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="<c:out value="/problem/create"/>">Dodaj nowe zgłoszenie</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<br>
<a href="<c:url value="/"/>">Home</a>
</body>
</html>
