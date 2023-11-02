<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">

<head>
    <title>Zaplanuj Jedzonko</title>
</head>

<body>

<%@ include file="/WEB-INF/header.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form class="padding-small text-center" method="post">
                    <h1 class="text-color-darker">Logowanie</h1>
                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="podaj swój login">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="podaj hasło">
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <c:if test="${not empty param.error}">
                        <p style="color: red;">Nieprawidłowe dane logowania. Spróbuj ponownie.</p>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</section>

<%@ include file="/WEB-INF/footer.jsp" %>

</body>
</html>