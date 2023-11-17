<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/26/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
<jsp:include page="/view/trangchu/header.jsp"></jsp:include>
<div class="container mt-4">
    <form action="/addCTSP" method="post">
        <div class="form-group">
            <label>Anh</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" value="${ctsp.anh}" name="anh">
                <option value="img/aoThun.jpg" ${ctsp.anh=="img/aoThun.jpg"?"selected":""}>img/aoThun.jpg</option>
                <option value="img/cadigan2.jpg" ${ctsp.anh=="img/aoThun.jpg"?"selected":""}>img/cadigan2.jpg</option>
                <option value="img/first.jpg" ${ctsp.anh=="img/aoThun.jpg"?"selected":""}>/img/first.jpg</option>
            </select>
        </div>
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
                <c:forEach items="${listSP}" var="sp" >
                    <option value="${sp.id}">${sp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>NSX</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="idnsx">
                <c:forEach items="${listNSX}" var="nsx" >
                    <option value="${nsx.id}">${nsx.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Mau sac</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="idms">
                <c:forEach items="${listMS}" var="ms" >
                    <option value="${ms.id}">${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Dong SP</label>
            <%--            // Load sản phẩm trong bảng spham--%>
            <select class="form-select" name="iddsp">
                <c:forEach items="${listDongSP}" var="dsp" >
                    <option value="${dsp.id}">${dsp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <c:if test="${listCTSP.size()==0}"><p>Khong co du lieu</p></c:if>

    <c:if test="${listCTSP.size()>0}">
        <table class="table table-hover">
            <thread>
                <tr>
                    <td>Anh</td>
                    <td>Id</td>
                    <td>San pham</td>
                    <td>Nam Bao Hanh</td>
                    <td>So luong ton</td>
                    <td>Gia nhap</td>
                    <td>Gia ban</td>
                    <td>NSX</td>
                    <td>Mau sac</td>
                    <td>Dong SP</td>
                    <td>Mo ta</td>
                    <td colspan="3">Action</td>

                </tr>
            </thread>
            <tbody>
            <c:forEach items="${listCTSP}" var="ctsp">
                <tr>
                    <td><img src="${ctsp.anh}" width="100px"></td>
                    <td>${ctsp.id}</td>
                    <td>${ctsp.idSP.getTen()}</td>
                    <td>${ctsp.namBH}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaNhap}</td>
                    <td>${ctsp.giaBan}</td>
                    <td>${ctsp.idNSX.getTen()}</td>
                    <td>${ctsp.idMS.getTen()}</td>
                    <td>${ctsp.idDongSP.getTen()}</td>
                    <td>${ctsp.moTa}</td>

                    <td colspan="3" >
                        <a href="/detailCTSP?id=${ctsp.id}" class="btn btn-outline-success"> Detail</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<jsp:include page="/view/trangchu/footer.jsp"></jsp:include>
</body>

</html>
