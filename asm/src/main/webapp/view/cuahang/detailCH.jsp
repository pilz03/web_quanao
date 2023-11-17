<%--
  Created by IntelliJ IDEA.
  User: HoiVN
  Date: 07/08/2023
  Time: 02:17
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
<form action="/updateCH" method="post">
  <label class="form-label">Id</label>
  <input type="text" class="form-control" value="${ch.id}" name="id" readonly>
  <label class="form-label">Ma</label>
  <input type="text" class="form-control" value="${ch.ma}" name="ma">
  <label class="form-label">Ten</label>
  <input type="text" class="form-control" value="${ch.ten}" name="ten">
  <label class="form-label">Dia chi</label>
  <input type="text" class="form-control" value="${ch.diaChi}" name="diaChi">
  <label class="form-label">Thanh pho</label>
  <input type="text" class="form-control" value="${ch.thanhPho}" name="thanhPho">
  <div class="form-group">
    <label class="form-label">Quoc gia</label>
    <select class="form-control" id="exampleFormControlSelect1" name="quocGia">
      <option value="Việt Nam" ${ch.quocGia=="Việt Nam"?"selected":""}>Việt Nam</option>
      <option value="Mỹ" ${ch.quocGia=="Mỹ"?"selected":""}>Mỹ</option>
    </select>
  </div>
  <br>
  <button type="submit" class="btn btn-primary">Update</button>
  <a href="/homeCH" class="btn btn-warning">Back</a>
</form>
</body>
</html>
