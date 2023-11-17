<%--
  Created by IntelliJ IDEA.
  User: HoiVN
  Date: 07/08/2023
  Time: 02:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>DongSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="container">
<form action="/addDongSP" method="post">
    <label class="form-label">Id</label>
    <input type="text" class="form-control" value="${dongSP.id}" name="id" readonly>
    <label class="form-label">Ma</label>
    <input type="text" class="form-control" value="${dongSP.ma}" name="ma">
    <label class="form-label">Ten</label>
    <input type="text" class="form-control" value="${dongSP.ten}" name="ten">
    <br>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Ma</td>
        <td>Ten</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.ma}</td>
            <td>${u.ten}</td>
            <td>
                <a href="/deleteDongSP?id=${u.id}" class="btn btn-danger">Delete</a>
                <a href="/detailDongSP?id=${u.id}" class="btn btn-info">Detail</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
