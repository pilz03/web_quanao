<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/13/2023
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Ma</th>
            <th scope="col">Ten</th>
            <th scope="col">Chuc nang</th>



        </tr>
        </thead>
        <tbody>
        <c:forEach items="${liMS}" var="ms">
            <tr>
                <td>${ms.id}</td>
                <td>${ms.ma}</td>
                <td>${ms.ten}</td>
                <td>
                    <a href="/detail?id=${ms.id}" class="btn btn-primary">Detail</a>
                    <a href="/form-add" class="btn btn-primary">FormAdd</a>
                    <a href="/form-update?id=${ms.id}" class="btn btn-primary">FormUpdate</a>
                    <a href="/delete?id=${ms.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <span>${mess}</span>
</div>
</body>
</html>
