<%--
  Created by IntelliJ IDEA.
  User: inrita
  Date: 2/10/2023 AD
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Course History</title>
</head>
<body style="margin-left: 100px; background-color: ${cookie.bg_color_cookie.value}">
<h3>Course Register History</h3>
<hr>
    <c:if test="${message != null}"> <%-- ถ้าไม่มีข้อมูลให้ไปลงทะเบียนก่อน --%>
        <h2 style="color: deeppink; background-color: lightcyan">
            ${message} <br><hr>
            <a href="course_list"><button>OK</button></a> <%--กลับไปที่ course_list เพื่อลงทะเบียน--%>
        </h2>
    </c:if>

<%--${courseRegistered.history} สั่งแสดงข้อมูลบน view แต่่ไม่ต้องแสดง--%>

    <c:if test="${message == null}"> <%-- ถ้ามีข้อมูลลงทะเบียนให้ทำตาม flow นี้ --%>
        <c:forEach items="${courseRegistered.history}" var="entry">
            <h3>${semesters[entry.key]}</h3>
            <c:forEach items="${entry.value}" var="subject" varStatus="vd">
                ${vs.count} ${subject.subjectId} ${subject.title} ${subject.credit}<hr>
            </c:forEach>
            <br>
        </c:forEach>
        <a href="index.jsp"><button>OK</button></a>
    </c:if>
</body>
</html>
