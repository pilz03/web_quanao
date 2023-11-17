<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/17/2023
  Time: 12:53 AM
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
    <form action="">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" value="${cV.id}">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" value="${cV.ma}" name="name">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" value="${cV.ten}" name="age">
        <a href="/homeCV" class="btn btn-primary">Quay lai</a>


    </form>
</div>
</body>
</html>
