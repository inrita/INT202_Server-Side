<%--
  Created by IntelliJ IDEA.
  User: inrita
  Date: 18/9/2023 AD
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%> <%--ใช้ library ตัวนี้มาทำงาน--%>
<head>
    <title>Multiplication Table</title>
</head>
<body>
<c:if test = "${message == null}">
    <h2>MultiplicationTable of ${param.number}</h2> <%--สามารถ access ผ่าน "param" ได้เลยไม่ต้องใช้ภาษา java เขียนเรียก--%>
    <hr>
    <table style="background-color: lightyellow;border: 2.5px dashed deeppink; padding: 10px ">
        <tr style="background-color: lightpink; text-align: center">
            <td colspan="5">${param.number}</td>
        </tr>
    <c:forEach begin="1" end="2000" var="n"> <%--แสดงตารางสูตรคูณ--%>
        <tr>
            <td>${param.number}</td>
            <td> x </td>
            <td> ${n} </td>
            <td> = </td>
            <td> ${n * param.number}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<c:if test = "${message != null}"> <%--check เงื่อไขว่าถ้า message != null จะไม่ให้เกิด error 500 แต่จะโชว์ message error แทน--%>
    <h3 style = "color:red"> Error::
        <hr>
        <sapn style = "color: darkblue">${message} </sapn> (${param.number == null ? 'Null' : param.number})</h3>
</c:if>

</body>
</html>
