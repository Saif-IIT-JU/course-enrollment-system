<%--
  Author: saifuzzaman
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>View Courses</title>
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
            <div class="container"
                 style="padding-top: 80px; padding-left: 50px; text-align: center">
                <h3>
                    <fmt:message key="course.view.heading"/>
                </h3>
                <div class="scrollableArea">
                    <table class="table table-warning table-striped">
                        <thead>
                        <tr>
                            <th><fmt:message key="course.code"/></th>
                            <th><fmt:message key="course.title"/></th>
                            <th><fmt:message key="course.credit"/></th>
                            <th><fmt:message key="enrollment"/></th>
                            <th><fmt:message key="action"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${courses}" var="course">
                            <tr>
                                <td><c:out value="${course.code}"/></td>
                                <td><c:out value="${course.title}"/></td>
                                <td><c:out value="${course.credit}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${course.hasNoTrainees()}">
                                            <c:out value="Empty"/>
                                        </c:when>

                                        <c:otherwise>
                                            <ul>
                                                <c:forEach var="trainee" items="${course.trainees}">
                                                    <li>
                                                        <c:out value="${trainee.getFullName()}"/>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:url var="courseUrl" value="/course">
                                        <c:param name="id" value="${course.id}"/>
                                    </c:url>
                                    <a href="${courseUrl}"><fmt:message key="edit"/></a>

                                    <c:url var="courseDeleteUrl" value="/course/delete">
                                        <c:param name="id" value="${course.id}"/>
                                    </c:url>
                                    <a href="${courseDeleteUrl}"><fmt:message key="delete"/> </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
