<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2023
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    footer {
      width: 100%;
      background: #343a40;
      padding: 40px;
      margin-top: 20px;
    }
    footer a {
      color: #f8f9fa!important
    }
    .bgc{
      background-image: url('static/banner.jpg');

    }
    .show_txt{
      display: inline-block;
      width: 100%;
      white-space: nowrap;
      overflow: hidden !important;
      text-overflow: ellipsis;
    }
    a .active{
      color: white;
    }

    footer .box form input {
      width: 280px;
      height: 42px;
      background:transparent;
      padding-left:20px;
      color:#fff;
      margin-top:30px;
    }

    footer .box form button {
      background:#362f2f;
      box-shadow: 5px 5px 4px rgba(0,0,0.25);
      width: 163px;
      height: 38px;
      margin-top:29px;
      color:#fff;
    }
    footer .box {
      width: 250px;
      color:#fff;
    }
  </style>
</head>
<body>
<!-- Footer -->
<footer class="text-light">
  <div class="container">
    <div class="row">
      <div class="col-md-3 col-lg-4 col-xl-3">
        <h5>Contact</h5>
        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
        <p class="mb-0">
          Địa chỉ: 995 Nguyễn Trãi, P14, Quận 5, TP.HCM <br>
          Số điện thoại: 0344800808 <br>
          Email: hello@paradox.vn
        </p>
      </div>

      <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">

      </div>

      <div class="col-md-6 col-lg-4 col-xl-4">
        <h5>About</h5>
        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
        <div class="box">
          <h3>LIÊN HỆ</h3>
          <form action="">
            <input type="text" placeholder="Địa chỉ email">
            <button>Nhận tin</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- Footer -->
</body>
</html>
