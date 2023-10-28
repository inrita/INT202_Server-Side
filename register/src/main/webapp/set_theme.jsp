<%--
  Created by IntelliJ IDEA.
  User: inrita
  Date: 6/10/2023 AD
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Your Theme</title>
</head>
<body style="background-color: ${cookie.bg_color_cookie.value}">
    <h2>Select your theme::</h2><hr>
    <form action="set_theme" method="post">
        <p>
            <input type="radio" name="bgColor" value="lightcyan">
            <button style="background-color: lightcyan">Light Cyan</button>
        </p>
        <p>
            <input type="radio" name="bgColor" value="lightgreen">
            <button style="background-color: lightgreen">Light Green</button>
        </p>
        <p>
            <input type="radio" name="bgColor" value="lightyellow">
            <button style="background-color: lightyellow">Light Yellow</button>
        </p>
        <p>
            <input type="radio" name="bgColor" value="lightpink">
            <button style="background-color: lightpink">Light Pink</button>
        </p>
        <hr>
        <input type="submit" value="OK">
    </form>

</body>
</html>
