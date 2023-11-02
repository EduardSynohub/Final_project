<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Opis sprzętu</title>
</head>
<body>
<%@include file="/WEB-INF/dashboard-header.jsp"%>
<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <%@ include file="/WEB-INF/side-panel.jsp" %>
    <div>
<table border="1">
  <thead>
  <th>Nazwa sprzętu</th>
  </thead>
  <tbody>
  <tr>
    <td><c:out value="${equipment.get().name}"/></td>
  </tr>
  </tbody>
</table>
<a href="<c:out value="/equip/all"/>">Powrót</a>
    </div>
  </div>
</section>
</body>
</html>
