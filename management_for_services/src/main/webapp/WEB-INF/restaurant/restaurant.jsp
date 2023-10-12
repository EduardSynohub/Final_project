<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Obecna restauracja</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Nazwa restauracji</th>
  <th>Adres</th>
  </thead>
  <tbody>
  <tr>
    <td><c:out value="${restaurant.get().name}"/></td>
    <td><c:out value="${restaurant.get().address}"/></td>
  </tr>
  </tbody>
</table>
<a href="<c:out value="/rest/all"/>">Powrót</a>
</body>
</html>
