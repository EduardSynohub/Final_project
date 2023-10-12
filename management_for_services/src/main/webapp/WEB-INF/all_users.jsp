<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Imię</th>
  <th>Nazwisko</th>
  <th>Stanowisko</th>
  <th>Restauracja</th>
  <th>Akcja</th>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user">
    <tr>
      <td><c:out value="${user.name}"/></td>
      <td><c:out value="${user.surname}"/></td>
      <td><c:out value="${user.jobTitle}"/></td>
      <td><c:out value="${user.restaurant}"/></td>
      <td>
        <a href="<c:out value="/admin/books/edit/${user.id}"/>">Edytuj</a>
        <a href="<c:out value="/admin/books/delete/${user.id}"/>">Usuń</a>
        <a href="<c:out value="/admin/books/get/${user.id}"/>">Pokaż</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
