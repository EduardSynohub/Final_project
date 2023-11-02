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
    <title>Dodawanie nowego serwisu</title>
</head>
<body>
<%@include file="/WEB-INF/dashboard-header.jsp"%>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="/WEB-INF/side-panel.jsp" %>
        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <c:url var="edit_url" value="/repair/edit"/>
                <form:form method="post" modelAttribute="repair_service" action="${edit_url}">
                    <form:hidden path="id"/>
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Edycja serwisu</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Nazwa serwisu</th>
                                <td class="col-7">
                                    <form:input path="name" class="w-100 p-1"/>
                                    <form:errors path="name"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Adres serwisu</th>
                                <td class="col-7">
                                    <form:input path="address" class="w-100 p-1" rows="5"/>
                                    <form:errors path="address"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Numer telefonu</th>
                                <td class="col-7">
                                    <form:input path="phoneNumber" class="w-100 p-1" rows="5"/>
                                    <form:errors path="phoneNumber"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Krótki opis serwisu</th>
                                <td class="col-7">
                                    <form:textarea path="description" class="w-100 p-1" rows="5"/>
                                    <form:errors path="description"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="col d-flex justify-content-end mb-2 noPadding">
                            <a href="<c:out value="/repair/all"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
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
