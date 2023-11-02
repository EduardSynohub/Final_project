<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  response.setCharacterEncoding("UTF-8");
  request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head lang="pl">

  <title>Header</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
        rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

</head>
<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-between">
    <a href="<c:out value="/"/>" class="navbar-brand main-logo main-logo-smaller">
      Serwis do <span>zgłoszeń</span>
    </a>
    <div class="d-flex justify-content-around">
      <sec:authorize access="isAuthenticated()">
      <h4 class="text-light mr-3"><p>Zalogowany jako: </p><sec:authentication property="principal.username"/></h4>
      </sec:authorize>
      <div class="circle-div text-center">
        <i class="fas fa-user icon-user"></i>
      </div>
    </div>
  </nav>
</header>