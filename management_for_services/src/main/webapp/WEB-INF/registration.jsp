<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Zaplanuj Jedzonko</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
        rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<%@ include file="header.jsp" %>

<section class="dashboard-section">
  <div class="container pt-4 pb-4">
    <div class="border-dashed view-height">
      <div class="container w-25">
        <!-- fix action, method -->
        <!-- add name attribute for all inputs -->
        <c:url var="edit_url" value="/user/edit/${user.id}"/>
        <form:form class="padding-small text-center" method="post" modelAttribute="user" action="${edit_url}">
          <h1 class="text-color-darker">Rejestracja</h1>
          <form:hidden path="id"/>
          <div class="form-group">
            <form:input type="text" class="form-control" path="name" placeholder="podaj imię"/>
            <form:errors path="name"/>
          </div>
          <div class="form-group">
            <form:input type="text" class="form-control" path="surname" placeholder="podaj nazwisko"/>
            <form:errors path="surname"/>
          </div>
          <div class="form-group">
            <form:input type="text" class="form-control" path="email" placeholder="podaj email"/>
            <form:errors path="email"/>
          </div>
          <div class="form-group">
            <form:input type="password" class="form-control" path="password" placeholder="podaj hasło"/>
            <form:errors path="password"/>
          </div>
          <div class="form-group">
            <form:input type="text" class="form-control" path="jobTitle" placeholder="podaj swoje stanowisko"/>
            <form:errors path="jobTitle"/>
          </div>
          <div class="form-group">
            <form:select class="form-control" path="restaurant.id" items="${list_of_restaurant}" itemValue="id" itemLabel="name" placeholder="wybierz restaurację"/>
            <form:errors path="restaurant"/>
          </div>
          <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
        </form:form>
      </div>
    </div>
  </div>
</section>

<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
