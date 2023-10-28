<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--สร้าง View ให้ตอบกลับเอกสาร html กลับไปให้ web browser--%>
<%--JSP คือ html ที่สามารถ access object (อยู่ในส่วนของ model) ของ java ได้ (ทำงานฝั่ง server)--%>

<html>
<head>
    <title>Subject List</title>
</head>
<body style="background-color: ${cookie.bg_cookie.value}"> <%--เรียก cookie.อ้างถึงชื่อ.อ้างถึง value--%>
  <div class = "flex-content" style = "margin: 100px; background-color: lightpink">
  <h1>Subject List::</h1>
    <hr>
      <table>
        <tr style="background-color: antiquewhite; color: darkblue">
<%--      อ้างอิงใส่จาก attibuted ที่สร้างใน class Subject--%>
          <td>Subject ID</td>
          <td>Title</td>
          <td>Credit</td>
        </tr>

<%--    เอา Libary มาใช้ อ้างด้วยตัว "c"--%>
<%--    choose -> http://java.sun.com/jsp/jstl/core เลือกผิดตัวมันจะทำงานไม่ได้--%>
        <c:forEach var = "subject" items = "${subjects}">
<%--          foreach คือการใช้ข้อมูลที่อยูใน request มาแสดงได้เลย--%>
<%--          items = "${subjects}" ใช้ที่อ้างจากตรงนี้ request.setAttribute("subjects", subjects);--%>
          <tr>
            <td>${subject.id}</td>
            <td>${subject.title}</td>
            <td>${subject.credit}</td>
            <td><input type="checkbox" value="${subject.id}"></td>
          </tr>
        </c:forEach>
      </table>
  </div>
</body>
</html>
