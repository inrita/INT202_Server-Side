<%--
  Created by IntelliJ IDEA.
  User: inrita
  Date: 25/9/2023 AD
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Cookie</title>
</head>
<body style="background-color: ${bgColor}">
    <h1>Test Cookies</h1><hr>
    <form action="test_cookie" method="post"> <%--ส่งกลับไปที่ method post--%>
        <%-- บนฝั่ง client เขียนอยู่บน form ไม่ต้องใส่ / เพราะต้องอ้างอิง URL เดิม forword ส่วนฝั่ง server ต้องใส่ / --%>
        Please select your theme: <br>
        &nbsp; &nbsp; - <input type="radio" name="bg" value="skyblue"
            ${bgColor == 'skyblue' ? 'checked' : ''}> Sky Blue <br>
        &nbsp; &nbsp; - <input type="radio" name="bg" value="pink"
            ${bgColor == 'pink' ? 'checked' : ''}> Pink <br>
        &nbsp; &nbsp; - <input type="radio" name="bg" value="palegreen"
            ${bgColor == 'palegreen' ? 'checked' : ''}> Pale Green <br>
        &nbsp; &nbsp; - <input type="radio" name="bg" value="lightyellow"
            ${bgColor == 'lightyellow' ? 'checked' : ''}> Light Yellow <br>
        <input type="submit">
    </form>

    <br><br>
    <a href="index.jsp">Go to Home Page</a>
</body>
</html>
