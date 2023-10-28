<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="myTag" uri="/WEB-INF/myTagLib.tld" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body style="background-color: ${cookie.bg_color_cookie.value}">  <%-- ใช้ cookie ในการช่วยจำสีพื้นหลังที่เราเคยเลือกไว้ --%>
                                                                  <%-- เรียก cookie.อ้างถึงชื่อ.อ้างถึง value --%>
<%--    <c:if test="${applicationScope.semester == null}">--%>
<%--        <c:set var="semester" scope="application" value="${myTag.getAllSemesters()}"/>--%>
<%--    </c:if>--%>
<%--ข้อมูล semester สามารถเอาไปใส่ใน Applicatiopn scope ได้เพราะข้อมูลเหมือนกัน --%>

    <h2>Menu</h2><hr>
        <a href="course_list">ลงทะเบียน</a><br>
        <a href="course-registered-history">ประวัติลงทะเบียน</a><br>
        <a href="set_theme">Choose theme</a><br>
</body>
</html>