<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <title>Home</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/img/banner.jpg" class="d-block w-100" width="1340px" height="350px">
        </div>
        <div class="carousel-item">
            <img src="/img/banner2.jpg" class="d-block w-100" width="1340px" height="350px">
        </div>
        <div class="carousel-item">
            <img src="/img/banner3.jpg" class="d-block w-100" width="1340px" height="350px">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>


<div class="container">
    <div class="row ">
        <div class="col-6">
            <h5 class="mt-2">SẢN PHẨM NỔI BẬT </h5>
        </div>
        <div class="col-6 text-end">
            <p>Xem chi tiết</p>
        </div>
    </div>

    <div class="row row-cols-1 row-cols-4 g-4">
        <c:forEach items="${listCTSP}" var="ctsp">
            <div class="col">
                <a href="/sanpham/detail?id=${ctsp.id}" class="btn">
                    <div class="card">
                        <img src="/${ctsp.anh}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${ctsp.idSP.getTen()}</h5>
                            <p class="card-text">${ctsp.giaBan} VND</p>
                        </div>
                    </div>
                </a>
            </div>

        </c:forEach>
    </div>

    <h5 class="mt-4">SẢN PHẨM MỚI VỀ </h5>
    <div class="row row-cols-1 row-cols-4 g-4">
        <c:forEach items="${listCTSP}" var="ctsp">
            <div class="col">
                <a href="/sanpham/detail?id=${ctsp.id}" class="btn">
                    <div class="card">
                        <img src="/${ctsp.anh}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${ctsp.idSP.getTen()}</h5>
                            <p class="card-text">${ctsp.giaBan} VND</p>
                        </div>
                    </div>
                </a>
            </div>

        </c:forEach>
    </div>
</div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
