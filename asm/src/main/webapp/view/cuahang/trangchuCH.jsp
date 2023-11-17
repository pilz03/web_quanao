<%--
  Created by IntelliJ IDEA.
  User: HoiVN
  Date: 07/08/2023
  Time: 02:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Cua hang</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="container">
<form action="/addCH" method="post">
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
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<table class="table">
  <thead>
  <tr>
    <td>ID</td>
    <td>Ma</td>
    <td>Ten</td>
    <td>Dia chi</td>
    <td>Thanh pho</td>
    <td>Quoc gia</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listCH}" var="u">
    <tr>
      <td>${u.id}</td>
      <td>${u.ma}</td>
      <td>${u.ten}</td>
      <td>${u.diaChi}</td>
      <td>${u.thanhPho}</td>
      <td>${u.quocGia}</td>
      <td>
        <a href="/deleteCH?id=${u.id}" class="btn btn-danger">Delete</a>
        <a href="/detailCH?id=${u.id}" class="btn btn-info">Detail</a>
      </td>
    </tr>
  </c:forEach>

  </tbody>
</table>
</body>
</html>
