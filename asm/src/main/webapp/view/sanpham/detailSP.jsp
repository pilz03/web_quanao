<%--
  Created by IntelliJ IDEA.
  User: HoiVN
  Date: 07/08/2023
  Time: 03:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="container">
<br>
<form action="/updateSP" method="post">
  <label class="form-label">Id</label>
  <input type="text" class="form-control" value="${sanPham.id}" name="id" readonly>
  <label class="form-label">Ma</label>
  <input type="text" class="form-control" value="${sanPham.ma}" name="ma">
  <label class="form-label">Ten</label>
  <input type="text" class="form-control" value="${sanPham.ten}" name="ten">
  <br>
  <button type="submit" class="btn btn-success">Update</button>
  <a href="/homeSP" class="btn btn-warning">Back</a>
</form>
</body>
</html>
