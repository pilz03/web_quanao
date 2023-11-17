<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SoiDiCode
  Date: 6/24/2023
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div>

<div class="container mt-2 ">

    <section class="row">
        <article class="col-6">
            <div class="card" style="width: 80%">
                <img src="/${product.anh}" width=" 100%"/>
            </div>
            <div class="row row-cols-3 mt-3">
                <div class="col" style="width: 20%">
                    <img class="img-fluid" src="/${product.anh}"/>
                </div>

                <div class="col" style="width: 20%">
                    <img class="img-fluid" src="/${product.anh}"/>
                </div>

                <div class="col" style="width: 20%">
                    <img class="img-fluid" src="/${product.anh}"/>
                </div>

                <div class="col" style="width: 20%">
                    <img class="img-fluid" src="/${product.anh}"/>
                </div>
            </div>
        </article>
        <aside class="col-6">
            <div class="card-body text-center">
                <h1 class="card-title fw-bold fs-6">${product.idSP.getTen()}</h1>

                <p><span class="fw-bold fs-6">Price :</span> ${product.giaBan} VND</p>
                <p><span class="fw-bold fs-6">Describe:</span> ${product.moTa}</p>
                <p class="mb-3">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </p>

                <p><span class="fw-bold fs-6">Quantity :</span>

                <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                    <button type="button" class="btn btn-outline-danger " onclick="down()"><i
                            class="fas fa-minus" style="color: #000000; width: 50px;"></i></button>
                    <input type="text" class="w-25 text-center" id="quantity1" value="1">
                    <button type="button" class="btn btn-outline-success  w-25" onclick="up()"><i
                            class=" fas fa-plus" style="color: #000000;"></i></button>
                </div>
                <br>
                <!-- <button style="width: 50px; height: 50px">&lsaquo;</button>
                <button style="width: 100px; height: 50px">1</button>
                <button style="width: 50px; height: 50px">&rsaquo;</button> -->
                <div class="row" style="margin-top: 10px;">
                    <span class="fw-bold fs-6">Option</span>

                    <div class="row" style="margin-top: 5px;">
                        <span class="col-3"></span>
                        <a href="/addToCart?id=${product.id}" class="col-3 btn btn-outline-success">Thêm giỏ hàng</a>
                        <span class="col-1"></span>
                        <a class="col-3 btn btn-outline-dark" href="/ban-hang/trang-chu">Back Home </a>
                        <span class="col-3"></span>
                    </div>

                </div>
            </div>
        </aside>
    </section>

</div>

<jsp:include page="footer.jsp"></jsp:include>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</body>
</html>
