<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie restaurację</title>
</head>
<body>
<%@include file="/WEB-INF/dashboard-header.jsp"%>
<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <%@ include file="/WEB-INF/side-panel.jsp" %>
      <div class="m-4 p-3 width-medium">
        <div class="dashboard-content border-dashed p-3 m-4 view-height">
          <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
              <h3 class="color-header text-uppercase">Lista restauracji</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
              <a href="<c:out value="/rest/create"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">
                Dodaj nową restaurację
              </a>
            </div>
          </div>
          <div class="schedules-content">
            <table class="table border-bottom">
  <thead>
  <tr class="d-flex">
    <th class="col-3">Nazwa restauracji</th>
    <th class="col-6">Adres</th>
    <th class="col-3 center">Akcja</th>
  </tr>
  </thead>
  <tbody class="text-color-lighter">
  <c:forEach items="${restaurants}" var="restaurant">
    <tr class="d-flex">
      <td class="col-3"><c:out value="${restaurant.name}"/></td>
      <td class="col-6"><c:out value="${restaurant.address}"/></td>
      <td class="col-3 d-flex align-items-center justify-content-center flex-wrap">
    <c:if test="${restaurant.id eq restaurant_id}">
        <a href="<c:out value="/rest/edit/${restaurant.id}"/>" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>
    </c:if>
        <a href="<c:out value="/rest/delete/${restaurant.id}"/>" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
    <c:if test="${restaurant.id eq restaurant_id}">
        <a href="<c:out value="/rest/get/${restaurant.id}"/>" class="btn btn-info rounded-0 text-light m-1">Pokaż</a>
      </td>
    </tr>
  </c:if>
  </c:forEach>
  </tbody>
</table>
    </div>
  </div>
      </div>
  </div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
