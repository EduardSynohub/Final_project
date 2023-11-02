<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Użytkownik</title>
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
            <h3 class="color-header text-uppercase">Szczegóły pracownika</h3>
          </div>
        </div>

        <div class="schedules-content">
          <table class="table border-bottom">
  <thead>
  <tr class="d-flex">
  <th class="col-1">Imię</th>
  <th class="col-2">Nazwisko</th>
  <th class="col-3">Stanowisko</th>
  <th class="col-4">Restauracja</th>
  <th class="col-2">Login</th>
  </tr>
  </thead>
            <tbody class="text-color-lighter">
  <tr class="d-flex">
    <td class="col-1"><c:out value="${user.get().name}"/></td>
    <td class="col-2"><c:out value="${user.get().surname}"/></td>
    <td class="col-3"><c:out value="${user.get().jobTitle}"/></td>
    <td class="col-4"><c:out value="${user.get().restaurant.name}"/></td>
    <td class="col-2"><c:out value="${user.get().username}"/></td>
  </tr>
  </tbody>
</table>
          <div class="col d-flex justify-content-end mb-2 noPadding">
          <a href="<c:out value="/user/all"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
