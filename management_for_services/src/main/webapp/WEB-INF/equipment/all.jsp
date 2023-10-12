<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie sprzęty</title>
</head>
<body>
<table border="1">
  <thead>
  <th>Nazwa sprzętu</th>
  <th>Akcja</th>
  </thead>
  <tbody>
  <c:forEach items="${equipments}" var="equipment">
    <tr>
      <td><c:out value="${equipment.name}"/></td><td>
        <a href="<c:out value="/equip/edit/${equipment.id}"/>">Edytuj</a>
        <a href="<c:out value="/equip/delete/${equipment.id}"/>">Usuń</a>
        <a href="<c:out value="/equip/get/${equipment.id}"/>">Pokaż</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
