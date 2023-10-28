<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body style="background-color: ${cookie.bg_cookie.value}"> <%-- ใช้ cookie ในการช่วยจำสีพื้นหลังที่เราเคยเลือกไว้ --%>
                                <%--เรียก cookie.อ้างถึงชื่อ.อ้างถึง value--%>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="test_cookie">Hello Servlet</a>
</body>
</html>
