<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/26/2023
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="container">
<form action="/updateNV" method="post">
    <div class="form-group">
        <label>ID</label>
        <input type="text" class="form-control" value="${nv.id}" name ="id">

    </div>
    <div class="form-group">
        <label>Ma</label>
        <input type="text" class="form-control" value="${nv.ma}" name ="ma">
    </div>
    <div class="form-group">
        <label>Ten</label>
        <input type="text" class="form-control" value="${nv.ten}" name ="ten">
    </div>
    <div class="form-group">
        <label>Ten dem</label>
        <input type="text" class="form-control" value="${nv.tenDem}" name ="tenDem">
    </div>
    <div class="form-group">
        <label>Ho</label>
        <input type="text" class="form-control" value="${nv.ho}" name ="ho">
    </div>

    <legend class="col-form-label col-sm-2 pt-0">Gioi tinh</legend>
    <div class="col-sm-10">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh"
                   value="Nam" ${nv.gioiTinh=="Nam"?"checked":""} >
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh"
                   value="Nữ" ${nv.gioiTinh=="Nữ"?"checked":""}>
            <label class="form-check-label">
                Nữ
            </label>
        </div>
    </div>

    <div class="form-group">
        <label>Ngay sinh</label>
        <input type="text" class="form-control" value="${nv.ngaySinh}" name="ngaySinh">
    </div>
    <div class="form-group">
        <label>Dia chi</label>
        <input type="text" class="form-control" value="${nv.diaChi}" name="diaChi">
    </div>
    <div class="form-group">
        <label>SDT</label>
        <input type="text" class="form-control" value="${nv.sdt}" name="sdt">
    </div>
    <div class="form-group">
        <label>Mat khau</label>
        <input type="text" class="form-control" value="${nv.matKhau}" name="matKhau">
    </div>
    <div class="form-group">
        <label>CV</label>
        <select class="custom-select mr-sm-2"  name="idcv">
            <c:forEach items="${listCV}" var="cv" >
                <option value="${cv.id}" ${nv.idCV.getId() == cv.id ?"selected":"" }>${cv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <label class="mr-sm-2" for="inlineFormCustomSelect">Trang thai</label>
    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="trangThai">
        <option  value=0 ${nv.trangThai==0?"selected":""}>Hoạt động</option>
        <option value=1 ${nv.trangThai==1?"selected":""} >Không hoạt động</option>
    </select>


    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
