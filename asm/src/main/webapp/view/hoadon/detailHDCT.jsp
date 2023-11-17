<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hoa don chi tiet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<jsp:include page="/view/trangchu/header.jsp"></jsp:include>
<div class="container">
<table class="table">
    <thead>
    <tr>
        <th>Ten san pham</th>
        <th>NSX</th>
        <th>Mau sac</th>
        <th>Dong SP</th>
        <th>So luong ton</th>
        <th>Gia ban</th>
        <th>Anh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listhdct}" var="hdct">
        <tr>
            <td>${hdct.getIdChiTietSP().getIdSP().getTen()}</td>
            <td>${hdct.getIdChiTietSP().getIdNSX().getTen()}</td>
            <td>${hdct.getIdChiTietSP().getIdMS().getTen()}</td>
            <td>${hdct.getIdChiTietSP().getIdDongSP().getTen()}</td>
            <td>${hdct.getIdChiTietSP().getSoLuongTon()}</td>
            <td>${hdct.getIdChiTietSP().getGiaBan()}</td>
            <td><img src="/${hdct.getIdChiTietSP().getAnh()}" style="width: 100px"></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
