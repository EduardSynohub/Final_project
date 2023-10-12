<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie restaurację</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Nazwa restauracji</th>
  <th>Adres</th>
  <th>Akcja</th>
  </thead>
  <tbody>
  <c:forEach items="${restaurants}" var="restaurant">
    <tr>
      <td><c:out value="${restaurant.name}"/></td>
      <td><c:out value="${restaurant.address}"/></td>
      <td>
        <a href="<c:out value="/rest/edit/${restaurant.id}"/>">Edytuj</a>
        <a href="<c:out value="/rest/delete/${restaurant.id}"/>">Usuń</a>
        <a href="<c:out value="/rest/get/${restaurant.id}"/>">Pokaż</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
