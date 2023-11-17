<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/27/2023
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
</head>
<body>
<div class="container">

    <form action="/updateCTSP" method="post">
        <input type="text" hidden value="${ctsp.anh}" name="anh">
        <div class="form-group">
            <label>ID</label>
            <input type="text" class="form-control" value="${ctsp.id}" name="id">

        </div>
        <div class="form-group">
            <label>Nam Bao Hanh</label>
            <input type="text" class="form-control" value="${ctsp.namBH}" name="namBH">
        </div>
        <div class="form-group">
            <label>Mo ta</label>
            <input type="text" class="form-control" value="${ctsp.moTa}" name="moTa">
        </div>
        <div class="form-group">
            <label>So luong ton</label>
            <input type="text" class="form-control" value="${ctsp.soLuongTon}" name="soLuongTon">
        </div>
        <div class="form-group">
            <label>Gia nhap</label>
            <input type="text" class="form-control" value="${ctsp.giaNhap}" name="giaNhap">
        </div>
        <div class="form-group">
            <label>Gia ban</label>
            <input type="text" class="form-control" value="${ctsp.giaBan}" name="giaBan">
        </div>

        <div class="form-group">
            <label>SP</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="idsp">
                <c:forEach items="${listSP}" var="sp">
                    <option value="${sp.id}" ${ctsp.idSP.getId() ==sp.id?"selected":"" } > ${sp.ten} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>NSX</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="idnsx">
                <c:forEach items="${listNSX}" var="nsx">
                    <option value="${nsx.id}" ${ctsp.idNSX.getId()==nsx.id?"selected":""} > ${nsx.ten} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Mau sac</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="idms">
                <c:forEach items="${listMS}" var="ms">
                    <option value="${ms.id}" ${ctsp.idMS.getId()==ms.id?"selected":""} > ${ms.ten} </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Dong SP</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="iddsp">
                <c:forEach items="${listDongSP}" var="d">
                    <option value="${d.id}" ${ctsp.idDongSP.getId()==d.id?"selected":""}  > ${d.ten} </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
