<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul class="nav flex-column long-bg">
  <li class="nav-item">
    <a class="nav-link" href="/user/dashboard">
      <span>Pulpit</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/user/all">
      <span>Użytkownicy</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/equip/all">
      <span>Sprzęt</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/repair/all">
      <span>Serwisy</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="/rest/all">
      <span>Restaurację</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/problem/all">
      <span>Zgłoszenia</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>
  <li class="nav-item">
    <sec:authorize access="isAuthenticated()">
      <c:set var="cleanedUserId" value="${fn:replace(userId, '//', '/')}"/>
      <c:url var="editUserUrl" value="/user/edit/${cleanedUserId}"/>
      <form action="${editUserUrl}" method="post" style="display: inline;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <a class="nav-link" href="javascript:void(0);" onclick="this.parentNode.submit();">
          <span>Edycja użytkownika</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </form>
    </sec:authorize>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/logout"/>">
      <span>Wyloguj</span>
      <i class="fas fa-angle-right"></i>
    </a>
  </li>

</ul>
