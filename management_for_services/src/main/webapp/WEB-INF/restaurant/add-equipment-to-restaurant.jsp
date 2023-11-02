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
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Dodawanie sprzętu do restauracji</title>
</head>
<body>
<%@include file="/WEB-INF/dashboard-header.jsp"%>
<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <%@ include file="/WEB-INF/side-panel.jsp" %>
    <div class="m-4 p-3 width-medium text-color-darker">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <form action="/rest/addEquipment" method="post">
          <input type="hidden" id="restaurantId" name="restaurantId" value="${restaurantId}">
          <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
              <div class="col"><h3 class="color-header text-uppercase">Dodaj sprzęt do restauracji</h3></div>
              <div class="col d-flex justify-content-end mb-2">
                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj</button>
              </div>
            </div>

            <table class="table borderless">
              <tbody>
              <tr class="d-flex">
                <th scope="row" class="col-2">Wybierz sprzęt</th>
                <td class="col-7">
                  <select name="equipmentId">
                    <c:forEach items="${list_of_equipment_in_restaurant}" var="equipment">
                      <option value="${equipment.id}">${equipment.name}</option>
                    </c:forEach>
                  </select>
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </td>
              </tr>
              </tbody>
            </table>
            <div class="col d-flex justify-content-end mb-2 noPadding">
              <a href="<c:out value="/rest/all"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
