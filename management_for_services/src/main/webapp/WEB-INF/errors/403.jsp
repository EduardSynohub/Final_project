<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<head>
  <title>Security with Spring Boot</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<h1 align="center" style="color: red">Dostęp zabroniony</h1>
<div align="center">
<a href="/user/dashboard" class="btn btn-outline-warning">Wróć na pulpit</a>
</div>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>