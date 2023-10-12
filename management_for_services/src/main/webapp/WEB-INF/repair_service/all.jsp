<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie serwisy naprawcze</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Nazwa serwisu</th>
  <th>Adres</th>
  <th>Numer telefonu</th>
  <th>Akcja</th>
  </thead>
  <tbody>
  <c:forEach items="${repair_services}" var="repair_service">
    <tr>
      <td><c:out value="${repair_service.name}"/></td>
      <td><c:out value="${repair_service.address}"/></td>
      <td><c:out value="${repair_service.phoneNumber}"/></td>
      <td>
        <a href="<c:out value="/repair/edit/${repair_service.id}"/>">Edytuj</a>
        <a href="<c:out value="/repair/delete/${repair_service.id}"/>">Usuń</a>
        <a href="<c:out value="/repair/get/${repair_service.id}"/>">Pokaż</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
