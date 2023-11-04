<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Edycja użytkownika</title>
</head>
<body>
<%@include file="/WEB-INF/dashboard-header.jsp"%>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="/WEB-INF/side-panel.jsp" %>



        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="m-4 border-dashed view-height">
                <c:url var="edit_url" value="/user/edit"/>
                <form:form method="post" modelAttribute="user" action="${edit_url}" acceptCharset="UTF-8">
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col">
                                <h3 class="color-header text-uppercase">
                                    Edytuj dane
                                </h3>
                            </div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">
                                    Zapisz
                                </button>
                            </div>
                        </div>
                        <form:hidden path="id"/>
                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Imię</h4></th>
                                <td class="col-7">
                                    <form:input path="name" class="w-100 p-1"/>
                                    <form:errors path="name"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Nazwisko</h4></th>
                                <td class="col-7">
                                    <form:input path="surname" class="w-100 p-1"/>
                                    <form:errors path="surname"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Username</h4></th>
                                <td class="col-3">
                                    <form:input path="username" class="p-1 w-100" value="User-J.Kowalski"/>
                                    <form:errors path="username"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Obejmowane stanowisko</h4></th>
                                <td class="col-3">
                                    <form:input path="jobTitle" class="p-1 w-100"/>
                                    <form:errors path="jobTitle"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Restauracja</h4></th>
                                <td class="col-3">
                                    <form:select class="p-1 w-100" path="restaurant.id" items="${list_of_restaurant}" itemValue="id" itemLabel="name" />
                                    <form:errors path="restaurant.id"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Hasło</h4></th>
                                <td class="col-3">
                                    <form:password path="password" class="p-1 w-100"/> Jeżeli nie chcesz zmieniać hasła, to pozostaw pole pustym
                                    <form:errors path="password"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>