<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/13/2023
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/add" method="post">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten">
        <button type="submit" class="btn btn-primary">Add</button>


    </form>
</div>
</body>
</html>
