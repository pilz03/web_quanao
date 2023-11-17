<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/20/2023
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thread>
        <tr>
            <td>ID</td>
            <td>Ma</td>
            <td>Ten</td>
            <td>Chuc nang</td>
        </tr>
    </thread>
    <tbody>
    <c:forEach items="${listNSX}" var="nsx">
        <tr>
            <td>${nsx.id}</td>
            <td>${nsx.ma}</td>
            <td>${nsx.ten}</td>
            <td>
                <a href="/detailNSX?id=${nsx.id}" class="btn btn-primary">Detail</a>
                <a href="/form-addNSX" class="btn btn-primary">FormAdd</a>
                <a href="/form-updateNSX?id=${nsx.id}" class="btn btn-primary">FormUpdate</a>
                <a href="/deleteNSX?id=${nsx.id}" class="btn btn-primary">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
