<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 08/08/2025
  Time: 11:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Students</title>
</head>
<body>
<h1>DANH SACH SINH VIEN</h1>
<form method="get" action="/search">
    <input placeholder="search name..." type="text" name="search" height="30px" value="${search}">
    <select style="height: 30px" name="sort">
        <option value="ASC">tang dan</option>
        <option value="DESC">giam dan</option>
    </select >
    <button type="submit">loc</button>
</form>
<table border="1px">
    <thead>
    <tr>
        <th>ID</th>
        <th>TEN</th>
        <th>EMAIL</th>
        <th>NGAY SINH</th>
        <th>DIEM TRUNG BINH</th>
        <th>HANH DONG</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>${s.birthday}</td>
            <td>${s.avgMark}</td>
            <td>
                <a href="/edit/${s.id}" style="text-decoration: none">SUA</a>
                <a href="/delete/${s.id}" style="text-decoration: none" onclick="return confirm('ban co chac muon xoa khong?')">XOA</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/addStudent">THEM SINH VIEN</a>
</body>
</html>
