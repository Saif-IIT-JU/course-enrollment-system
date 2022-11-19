<%--
  Author: saifuzzaman
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Here</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:url var="bootstrapUrl" value="/css/bootstrap-4.0.0.min.css"></c:url>
    <link href="${bootstrapUrl}" rel="stylesheet">
    <c:url var="MyCSSUrl" value="/css/custom-1.0.0.css"/>
    <link href="${MyCSSUrl}" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<jsp:include page="header.jsp"/>

<c:set var="sessionUser" value="${SESSION_USER}"/>
<c:if test="${sessionUser != null}">
    <c:redirect url="dashboard"/>
</c:if>

<center>
    <div class="container" style="padding: 140px; width: 100%; height: 100%">
        <c:set var="loginAlert" value="${LoginAlert}"/>
        <c:if test="${loginAlert != null}">
            <div>
                <div class="alert alert-success alert-dismissible" style="margin-left: 180px; margin-right: 180px">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Alert!</strong> <c:out value="${loginAlert}"/>
                </div>
            </div>
            <c:set var="LoginAlert" value="${null}"/>
        </c:if>
        <div class="card" style="width: 500px;">
            <div class="card-body text-left">
                <h4 class="card-title text-center">
                    <fmt:message key="login.heading"/>
                </h4>
                <div class="container">
                    <form:form action="login/process" method="post" modelAttribute="user">
                        <div class="form-group">
                            <form:label path="username"><fmt:message key="login.username"/></form:label>
                            <form:input type="text"
                                        class="form-control"
                                        path="username"/>
                            <form:errors path="username" cssClass="alert-danger"/>
                        </div>

                        <div class="form-group">
                            <form:label path="password"><fmt:message key="login.password"/></form:label>
                            <form:input type="password"
                                        class="form-control"
                                        path="password"/>
                            <form:errors path="password" cssClass="alert-danger"/>
                        </div>

                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-warning" style="text-align: center"><fmt:message key="form.submit"/></button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</center>

<jsp:include page="footer.jsp"/>
</body>
</html>
