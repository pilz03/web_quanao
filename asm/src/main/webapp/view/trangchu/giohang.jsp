<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gio hang </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<jsp:include page="/view/trangchu/header.jsp"></jsp:include>
<table class="table">
    <thead>
    <tr class="text-center">
        <td>STT</td>

        <td>TenSP</td>
        <td>GiaBan</td>
        <td>Soluong</td>
        <td>Anh</td>
        <td>Tổng tiền</td>
        <td>Chuc nang</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSP}" var="it" varStatus="loop">
        <tr class="text-center">
            <td>${loop.count}</td>
            <td>${it.tenSp}</td>
            <td>${it.giaBan}</td>
            <td>
                <div class="btn-group text-center" role="group" aria-label="Basic example">
                    <a href="/editquantity?num=1&id=${it.idSp}" type="button" class="btn btn-secondary">+</a>
                    <input type="text" value="${it.soLuong}" class="form-control" style="width: 50px">
                    <a href="/editquantity?num=-1&id=${it.idSp}" type="button" class="btn btn-secondary">-</a>
                </div>
            </td>

            <td><img src="${it.anh}" style="width: 100px"></td>
            <td>${it.soLuong * it.giaBan } VND</td>

            <td>
                <a href="/gio-hang/xoa?id=${it.idSp}"><i class="fa-regular fa-trash-can"
                                                         style="color: #ff0000;"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <a href="/ban-hang/trang-chu">Home</a>

</table>
<div class="row mt-5 border-1" >

    <div class="offset-3 col-md-6">

        <table class="table table-hover table-bordered-bottom">
            <tbody>

            <tr>
                <th colspan="2">
                    <div class="row">
                        <div class="col-9">
                            <input type="text" name="" id="" placeholder="Nhập mã giảm giá"
                                   class="form-control">
                        </div>
                        <div class="col-3 text-center">
                            <button class="btn btn-outline-success">Áp dụng</button>
                        </div>
                    </div>
                </th>
            </tr>
            <tr>
                <div class="row ">
                    <td class="col-6 fw-bolder">Số lượng</td>
                    <td class="col-6 text-end fw-bolder">${size}</td>
                </div>
            </tr>
            <tr>
                <div class="row ">
                    <td class="col-6 fw-bolder">Tạm tính</td>
                    <td class="col-6 text-end fw-bolder total" >${tongTien}</td>

                </div>
            </tr>
            <tr>
                <div class="row ">
                    <td class="col-6 fw-bolder">Phí vận chuyển </td>
                    <td class="col-6 text-end fw-bolder">0 VND</td>
                </div>
            </tr>
            <tr>
                <div class="row ">
                    <td class="col-6 fw-bolder">Tổng tiền</td>
                    <td class="col-6 text-end fw-bolder total" >${tongTien}</td>
                </div>
            </tr>


            </tbody>
        </table>

    </div>
</div>
<div class="row mt-3"><a href="/thanhtoan" class="btn btn-secondary col-4 offset-4 ">Thanh toán</a></div>

</body>
</html>
