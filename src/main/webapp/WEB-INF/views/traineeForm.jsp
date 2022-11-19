<%--
  Author: saifuzzaman
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Trainee Details</title>
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
<div class="container-fluid">
    <div class="row">
        <div class="col-xl-3">
            <jsp:include page="menuView.jsp"/>
        </div>
        <div class="col-xl-9">
            <center>
                <div class="container" style="padding-top: 120px;">
                    <div class="card" style="width: 500px">
                        <div class="card-body text-left">
                            <h4 class="card-title text-center">
                                <fmt:message key="trainee.form.heading"/>
                            </h4>
                            <div class="container">
                                <form:form action="/trainee/process"
                                           class="was-validated"
                                           method="post"
                                           modelAttribute="trainee">
                                    <form:input type="hidden" path="id"/>
                                    <div class="form-group">
                                        <form:label path="firstName"><fmt:message key="trainee.lastname"/></form:label>
                                        <form:input type="text"
                                                    class="form-control"
                                                    path="firstName"/>
                                        <form:errors path="firstName" cssClass="alert-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <form:label path="lastName"><fmt:message key="trainee.lastname"/></form:label>
                                        <form:input type="text"
                                                    class="form-control"
                                                    path="lastName"/>
                                        <form:errors path="lastName" cssClass="alert-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <form:label path="email"><fmt:message key="trainee.email"/></form:label>
                                        <form:input type="text"
                                                    class="form-control"
                                                    path="email"/>
                                        <form:errors path="email" cssClass="alert-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <form:label path="phone"><fmt:message key="trainee.phone"/></form:label>
                                        <form:input type="text"
                                                    class="form-control"
                                                    path="phone"/>
                                        <form:errors path="phone" cssClass="alert-danger"/>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-warning" style="text-align: center">
                                            <fmt:message key="form.submit"/>
                                        </button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </center>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
