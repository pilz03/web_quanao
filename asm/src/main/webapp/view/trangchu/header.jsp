<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<div class=" container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light container">
        <a class="navbar-brand " href="/ban-hang/trang-chu"><img class="me-3" src="/img/Fairy-Tail-symbol%20(1).jpg" style="width: 30%;"
                                                                 alt="">AR MOUS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ">
                <li class="nav-item active">
                    <a class="nav-link ms-5" style="white-space: nowrap;" href="/ban-hang/trang-chu">Trang Chủ <span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="white-space: nowrap;" href="/hoadon/home">Quản lý hóa đơn</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" style="white-space: nowrap;" href="/homeCTSP">Quản Lý Sản Phẩm</a>--%>
<%--                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" style="white-space: nowrap;" href="/banhang/gioi-thieu">Giới thiệu</a>
                </li>
                <div class="dropdown">
                    <a href="#" class="btn  dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thong tin
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/homeCV">Chuc vu</a></li>
                        <li><a class="dropdown-item" href="/homeMS">Mau sac</a></li>
                        <li><a class="dropdown-item" href="/homeNSX">NSX</a></li>
                        <li><a class="dropdown-item" href="/homeDongSP">Dong SP</a></li>
                        <li><a class="dropdown-item" href="/homeCH">Cua hang</a></li>
                        <li><a class="dropdown-item" href="/homeNV">Nhan vien</a></li>
                        <li><a class="dropdown-item" href="/homeKH">Khach hang</a></li>
                        <li><a class="dropdown-item" href="/homeSP">San pham</a></li>
                        <li><a class="dropdown-item" href="/homeCTSP">Chi tiet SP</a></li>
                    </ul>
                </div>

            </ul>
        </div>
    </nav>

</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>
