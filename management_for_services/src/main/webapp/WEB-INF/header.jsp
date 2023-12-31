<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>

  <title>Header</title>

  <meta charset="utf-8" lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
        rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

</head>
<body>

<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-around">
    <a href="/" class="navbar-brand main-logo">
      Serwis do <span>zgłoszeń</span>
    </a>
    <ul class="nav nounderline text-uppercase">
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="/login">logowanie</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="/create">rejestracja</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link" href="/problem/all">Zgłoszenia</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link disabled" href="/about">O nas</a>
      </li>
    </ul>
  </nav>
</header>
</body>
</html>
