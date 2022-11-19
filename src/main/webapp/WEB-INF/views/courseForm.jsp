<%--
  Author: saifuzzaman
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Course Details</title>
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
                <div class="container" style="padding-top: 120px; padding-bottom: 7px">
                    <div class="card" style="width: 500px">
                        <div class="card-body text-left">
                            <h4 class="card-title text-center">
                                <fmt:message key="course.form.heading"/>
                            </h4>
                            <div class="container">
                                <form:form action="/course/process"
                                           method="post"
                                           modelAttribute="course">
                                    <form:input type="hidden" path="id"/>
                                    <div class="form-group">
                                        <form:label path="code"><fmt:message key="course.code"/></form:label>
                                        <form:input class="form-control" path="code"/>
                                        <form:errors path="code" cssClass="alert-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <form:label path="title"><fmt:message key="course.title"/></form:label>
                                        <form:input class="form-control" path="title"/>
                                        <form:errors path="title" cssClass="alert-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <form:label path="credit"><fmt:message key="course.credit"/></form:label>
                                        <form:input class="form-control" path="credit"/>
                                        <form:errors path="credit" cssClass="alert-danger"/>
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
