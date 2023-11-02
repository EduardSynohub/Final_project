<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  response.setCharacterEncoding("UTF-8");
  request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
  <meta charset="UTF-8">
  <title>Dodawanie nowego zgłoszenia</title>
</head>
<body>
<%@include file="/WEB-INF/dashboard-header.jsp"%>
<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <%@ include file="/WEB-INF/side-panel.jsp" %>
    <div class="m-4 p-3 width-medium text-color-darker">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <form:form method="post" modelAttribute="breakdown">
          <form:hidden path="id"/>
          <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
              <div class="col"><h3 class="color-header text-uppercase">Nowe zgłoszenie</h3></div>
              <div class="col d-flex justify-content-end mb-2">
                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj</button>
              </div>
            </div>

            <table class="table borderless">
              <tbody>
              <tr class="d-flex">
                <th scope="row" class="col-2">Opisz problem</th>
                <td class="col-7">
                  <form:textarea path="description" class="w-100 p-1"/>
                  <form:errors path="description"/>
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Data zgłoszenia</th>
                <td class="col-2">
                  <form:input path="dateOfNotification" type="date" class="w-100 p-1"/>
                  <form:errors path="dateOfNotification"/>
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Data przyjazdu technika</th>
                <td class="col-2">
                  <form:input path="dateOfArrival" type="date" class="w-100 p-1"/>
                  <form:errors path="dateOfArrival"/>
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Wybierz sprzęt</th>
                <td class="col-2">
                  <form:select path="equipment.id" items="${list_of_equipments}" itemValue="id" itemLabel="name" />
                  <form:errors path="equipment"/>
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Wybierz serwis</th>
                <td class="col-2">
                  <form:select path="repairService.id" items="${list_of_repair_services}" itemValue="id" itemLabel="name" />
                  <form:errors path="repairService"/>
                </td>
              </tr>
              </tbody>
            </table>
            <div class="col d-flex justify-content-end mb-2 noPadding">
              <a href="<c:out value="/problem/all"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
