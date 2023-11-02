<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Wszystkie sprzęty</title>
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
            <h3 class="color-header text-uppercase">Lista sprzętów</h3>
          </div>
          <div class="col d-flex justify-content-end mb-2 noPadding">
            <a href="<c:out value="/equip/create"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj nowy sprzęt</a>
          </div>
        </div>

        <div class="schedules-content">
          <table class="table border-bottom">
            <thead>
            <tr class="d-flex">
              <th class="col-10">Nazwa sprzętu</th>
              <th class="col-2 center">Akcje</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">
            <c:forEach items="${equipments}" var="equipment">
              <tr class="d-flex">
                <td class="col-10"><c:out value="${equipment.name}"/></td>
                <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
                  <a href="<c:out value="/equip/edit/${equipment.id}"/>" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>
                  <a href="<c:out value="/equip/delete/${equipment.id}"/>" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                </td>
              </tr>
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
