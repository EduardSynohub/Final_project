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
      <td><c:out value="${user.restaurant.name}"/></td>
      <td>
        <a href="<c:out value="/user/edit/${user.id}"/>">Edytuj</a>
        <a href="<c:out value="/user/delete/${user.id}"/>">Usuń</a>
        <a href="<c:out value="/user/get/${user.id}"/>">Pokaż</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="<c:url value="/"/> ">Home</a>

</body>
</html>
