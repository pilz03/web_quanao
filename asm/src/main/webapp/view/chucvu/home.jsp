<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/17/2023
  Time: 12:42 AM
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
        <c:forEach items="${listCV}" var="cv">
            <tr>
                <td>${cv.id}</td>
                <td>${cv.ma}</td>
                <td>${cv.ten}</td>
                <td>
                    <a href="/detailCV?id=${cv.id}" class="btn btn-primary">Detail</a>
                    <a href="/form-addCV" class="btn btn-primary">FormAdd</a>
                    <a href="/form-updateCV?id=${cv.id}" class="btn btn-primary">FormUpdate</a>
                    <a href="/deleteCV?id=${cv.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <span>${mess}</span>
</div>
</body>
</html>
