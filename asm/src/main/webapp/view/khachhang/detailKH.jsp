<%--
  Created by IntelliJ IDEA.
  User: HoiVN
  Date: 07/08/2023
  Time: 01:53
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
<form action="/updateKH" method="post">
  <label class="form-label">Id</label>
  <input type="text" class="form-control" value="${kh.id}" name="id" readonly>
  <label class="form-label">Ma</label>
  <input type="text" class="form-control" value="${kh.ma}" name="ma">
  <label class="form-label">Ten</label>
  <input type="text" class="form-control" value="${kh.ten}" name="ten">
  <label class="form-label">Ten dem</label>
  <input type="text" class="form-control" value="${kh.tenDem}" name="tenDem">
  <label class="form-label">Ho</label>
  <input type="text" class="form-control" value="${kh.ho}" name="ho">

  <label class="form-label">Ngay sinh</label>
  <input type="date" class="form-control" value="${kh.ngaySinh}" name="ngaySinh">

  <label class="form-label">SDT</label>
  <input type="text" class="form-control" value="${kh.sdt}" name="sdt">
  <label class="form-label">Dia chi</label>
  <input type="text" class="form-control" value="${kh.diaChi}" name="diaChi">
  <label class="form-label">Thanh pho</label>
  <input type="text" class="form-control" value="${kh.thanhPho}" name="thanhPho">
  <label class="form-label">Quoc gia</label>
  <input type="text" class="form-control" value="${kh.quocGia}" name="quocGia">
  <label class="form-label">Mat khau</label>
  <input type="text" class="form-control" value="${kh.matKhau}" name="matKhau">
  <br>
  <button type="submit" class="btn btn-primary">Update</button>
  <a href="/homeKH" class="btn btn-warning">Back</a>
</form>
</body>
</html>
