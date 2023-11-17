<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 2:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <title>Hoa Don</title>
</head>
<body>
<jsp:include page="/view/trangchu/header.jsp"></jsp:include>
<div class="container-fluid">

    <form action="/hoadon/timkiem" method="post" class="mt-4">
        <div class="row">
            <div class="col-2">
                <input type="date" class="form-control" name="ngayBatDau">
            </div>
            <div class="col-2">
                <input type="date" class="form-control" name="ngayKetThuc">
            </div>
            <div class="col-2">
                <button class="btn btn-outline-danger" type="submit">Search</button>
            </div>
        </div>
    </form>
    <div class="row mt-4">
        <h2>Danh sách hóa đơn : ${mess} </h2>

    </div>

    <div class="row mt-3">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Ma</th>
                <th>Ngay Tao</th>
                <th>Ngay Thanh Toan</th>
                <th>Ngay Nhan</th>
                <th>Dia chi</th>
                <th>SDT</th>
                <th>Ten nguoi nhan</th>
                <th>Tinh Trang</th>
                <th rowspan="1">Chuc Nang</th>

            </tr>
            </thead>

            <tbody>
            <c:forEach items="${listHD}" var="hd">
                <tr>
                    <td>${hd.ma}</td>
                    <td>${hd.ngayTao}</td>
                    <td>${hd.ngayThanhToan}</td>
                    <td>${hd.ngayNhan}</td>
                    <td>${hd.diaChi}</td>
                    <td>${hd.sdt}</td>
                    <td>${hd.tenNguoiNhan}</td>
                    <td>${hd.tinhTrang == 1?"Da thanh toan":hd.tinhTrang == -1?"Da huy":"Cho thanh toan"}</td>
                    <td>
                        <a href="/hoadon/detail?id=${hd.id}" class="btn btn-outline-success">Detail</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/view/trangchu/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
