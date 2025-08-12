<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 09/08/2025
  Time: 11:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE</title>
</head>
<body>
<h2>UPDATE STUDENT</h2>
<form action="/edit/${id}" method="post" style="border: 1px">

    <label for="name">TEN:</label><br>
    <input type="text" id="name" name="name" value="${student.name}"><br>

    <label for="email">EMAIL:</label><br>
    <input type="text" name="email" id="email" value="${student.email}"><br>

    <label for="birthday">NGAY SINH:</label><br>
    <input type="date" id="birthday" name="birthday" value="${student.birthday}"><br>

    <label for="avgMark" >DIEM TRUNG BINH</label ><br>
    <input type="number" id="avgMark" name="avgMark" value="${student.avgMark}"><br>

    <input type="submit" value="SUA">

</form>

</body>
</html>
