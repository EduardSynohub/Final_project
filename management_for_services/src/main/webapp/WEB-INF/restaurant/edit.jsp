<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Tworzenie restauracji</title>
</head>
<body>
<%@ include file="/WEB-INF/dashboard-header.jsp" %>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="/WEB-INF/side-panel.jsp" %>
        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <c:url var="edit_url" value="/rest/edit"/>
                <form:form method="post" modelAttribute="restaurant" action="${edit_url}">
                    <form:hidden path="id"/>
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Edycja restauracji</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Nazwa restauracji</th>
                                <td class="col-7">
                                    <form:input path="name" class="w-100 p-1"/>
                                    <form:errors path="name"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Adres restauracji</th>
                                <td class="col-7">
                                    <form:input path="address" class="w-100 p-1" rows="5"/>
                                    <form:errors path="address"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="col d-flex justify-content-end mb-2 noPadding">
                            <a href="<c:out value="/rest/all"/>" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
