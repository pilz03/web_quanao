<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/25/2023
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/saveNV" method="post">
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
            <input type="text" class="form-control" value="${nv.ten}" name ="ten" >
        </div>
        <div class="form-group">
            <label>Ten dem</label>
            <input type="text" class="form-control" value="${nv.tenDem}" name ="tenDem" >
        </div>
        <div class="form-group">
            <label>Ho</label>
            <input type="text" class="form-control" value="${nv.ho}" name ="ho" >
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
            <input type="date" class="form-control" value="${nv.ngaySinh}" name="ngaySinh">
        </div>
        <div class="form-group">
            <label>Dia chi</label>
            <input type="text" class="form-control" value="${nv.diaChi}" name="diaChi" >
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
<%--            // Load chức vụ trong bảng chức vụ--%>
            <select class="custom-select mr-sm-2"  name="idcv">
                <c:forEach items="${listCV}" var="cv" >
                <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>
        </div>
        <label class="mr-sm-2" for="inlineFormCustomSelect">Trang thai</label>
        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="trangThai">
            <option value=0 ${nv.trangThai==0?"selected":""}>Hoạt động</option>
            <option value=1 ${nv.trangThai==1?"selected":""}>Không hoạt động</option>
        </select>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <table class="table">
        <thread>
            <tr>
                <td>ID</td>
                <td>Ma</td>
                <td>Ten</td>
                <td>Ten dem</td>
                <td>Ho</td>
                <td>Gioi tinh</td>
                <td>Ngay sinh</td>
                <td>Dia chi</td>
                <td>SDT</td>
                <td>Mat khau</td>
                <td>CV</td>
                <td>Trang thai</td>

            </tr>
        </thread>
        <tbody>
        <c:forEach items="${listNV}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.ho}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.sdt}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.idCV.getTen()}</td>
                <td>${nv.trangThai==1?"Không hoạt động":"Hoạt động"}</td>
                <td>
                    <a href="/detailNV?id=${nv.id}" class="btn btn-primary"> Detail</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
