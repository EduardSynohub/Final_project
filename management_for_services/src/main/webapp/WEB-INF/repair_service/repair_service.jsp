<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Informacja o serwisie</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Nazwa serwisu</th>
  <th>Adres</th>
  <th>Numer telefonu</th>
  </thead>
  <tbody>
  <tr>
    <td><c:out value="${repair_service.get().name}"/></td>
    <td><c:out value="${repair_service.get().address}"/></td>
    <td><c:out value="${repair_service.get().phoneNumber}"/></td>
  </tr>
  </tbody>
</table>
<a href="<c:out value="/repair/all"/>">Powrót</a>
</body>
</html>
