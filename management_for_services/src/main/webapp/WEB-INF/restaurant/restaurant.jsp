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
            <h3 class="color-header text-uppercase"><c:out value="${restaurant.get().name}"/>, <c:out value="${restaurant.get().address}"/></h3>
          </div>
          <div class="col d-flex justify-content-end mb-2 noPadding">
            <a href="<c:out value="/rest/addEquipment"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">
              Dodaj sprzęt do restauracji
            </a>
            <a href="<c:out value="/rest/addRepairService"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">
              Dodaj serwis do restauracji
            </a>
          </div>
        </div>

        <div class="schedules-content">
          <table class="table border-bottom">
            <thead>
            <tr class="d-flex">
              <th class="col-11">Sprzęt w restauracji</th>
              <th class="col-1 center">Akcja</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">
            <c:forEach items="${restaurant.get().equipments}" var="equipment">
              <tr class="d-flex">
              <td class="col-11"><c:out value="${equipment.name}"/></td>
              <td class="col-1 d-flex align-items-center justify-content-center flex-wrap">
              <a href="<c:out value="/rest/deleteEquipment/${restaurant.get().id}/${equipment.id}"/>" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      <div class="schedules-content">
          <table class="table border-bottom">
            <thead>
            <tr class="d-flex">
              <th class="col-11">Serwisy restauracji</th>
              <th class="col-1 center">Akcja</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">
            <c:forEach items="${restaurant.get().repairServices}" var="repairService">
              <tr class="d-flex">
                <td class="col-11"><c:out value="${repairService.name}"/></td>
                <td class="col-1 d-flex align-items-center justify-content-center flex-wrap">
                  <a href="<c:out value="/rest/deleteRepairService/${restaurant.get().id}/${repairService.id}"/>" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        <div class="col d-flex justify-content-end mb-2 noPadding">
          <a href="<c:out value="/rest/all"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
        </div>
      </div>
        </div>
      </div>
    </div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
