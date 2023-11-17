<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2023
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<jsp:include page="/view/trangchu/header.jsp"></jsp:include>
<div class="row text-center mt-3 mb-3"> <h3>Thông tin khách hàng </h3> </div>
<div class="container" style="width: 540px">

    <form action="/xacnhan" method="post">



        <div class="form-group">
            <label>Ten Nguoi Nhan</label>
            <input type="text" class="form-control" name="ten">
        </div>
        <div class="form-group">
            <label>SDT </label>
            <input type="text" class="form-control" name="sdt" >
        </div>
        <div class="form-group">
            <label>Dia chi </label>
            <input type="text" class="form-control" name="dchi">
        </div>
        <div class="row mt-3">
            <button type="submit" class="btn btn-secondary col-4 offset-4 ">Xác nhận thanh toán</button>
        </div>



    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>
