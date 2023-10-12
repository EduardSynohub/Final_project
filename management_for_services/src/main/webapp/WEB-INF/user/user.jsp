<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Użytkownik</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Imię</th>
  <th>Nazwisko</th>
  <th>Stanowisko</th>
  <th>Restauracja</th>
  </thead>
  <tbody>
  <tr>
    <td><c:out value="${user.get().name}"/></td>
    <td><c:out value="${user.get().surname}"/></td>
    <td><c:out value="${user.get().jobTitle}"/></td>
    <td><c:out value="${user.get().restaurant.name}"/></td>
  </tr>
  </tbody>
</table>
<a href="<c:out value="/user/all"/>">Powrót</a>
</body>
</html>
