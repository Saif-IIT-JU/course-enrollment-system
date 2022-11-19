<%--
  Author: saifuzzaman
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="MyCSSUrl" value="/css/custom-1.0.0.css"/>
<link href="${MyCSSUrl}" rel="stylesheet">
<div class="scrollableMenu">
    <div class="container" style="padding-top: 120px;">
        <div class="card" style="width: 300px">
            <div class="card-body text-left">
                <h4 class="card-title text-center"><fmt:message key="dashboard"/></h4>
                <div class="container">
                    <c:url var="newCourse" value="/course"/>
                    <a href="${newCourse}">
                        <button type="button" class="btn btn-warning btn-block"><fmt:message key="add.course"/></button>
                    </a><br>

                    <c:url var="coursesUrl" value="/courses"/>
                    <a href="${coursesUrl}">
                        <button type="button" class="btn btn-warning btn-block"><fmt:message key="view.courses"/></button>
                    </a><br>

                    <c:url var="traineeUrl" value="/trainee"/>
                    <a href="${traineeUrl}">
                        <button type="button" class="btn btn-warning btn-block"><fmt:message key="add.trainee"/></button>
                    </a><br>

                    <c:url var="traineesUrl" value="/trainees"/>
                    <a href="${traineesUrl}">
                        <button type="button" class="btn btn-warning btn-block"><fmt:message key="view.trainees"/></button>
                    </a><br>

                    <c:url var="enrollmentUrl" value="/enrollment"/>
                    <a href="${enrollmentUrl}">
                        <button type="button" class="btn btn-warning btn-block"><fmt:message key="enrollment"/></button>
                    </a><br>

                    <c:url var="unenrollmentUrl" value="/unenrollment"/>
                    <a href="${unenrollmentUrl}">
                        <button type="button" class="btn btn-warning btn-block"><fmt:message key="unenrollment"/></button>
                    </a><br>
                </div>
            </div>
        </div>
    </div>
</div>