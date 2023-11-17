package com.example.asm.controller;

import com.example.asm.model.HoaDon;
import com.example.asm.model.HoaDonChiTiet;
import com.example.asm.responsitory.HoaDonChiTietResponsitory;
import com.example.asm.responsitory.HoaDonResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "HoaDonServlet", value = {
        "/hoadon/home",

        "/hoadon/timkiem",
        "/hoadon/detail"
})
public class HoaDonServlet extends HttpServlet {
    private final HoaDonResponsitory repo = new HoaDonResponsitory();
    private HoaDonChiTietResponsitory hoaDonChiTietResponsitory = new HoaDonChiTietResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/home")) {
            request.setAttribute("listHD", repo.getHD());
            request.getRequestDispatcher("/view/hoadon/homeHD.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            String id = request.getParameter("id");
            ArrayList<HoaDonChiTiet> lhdct = hoaDonChiTietResponsitory.getbyHDCT(id);
            request.setAttribute("listhdct",lhdct);


            request.getRequestDispatcher("/view/hoadon/detailHDCT.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hoadon/timkiem")) {
            String ngayBD = request.getParameter("ngayBatDau");
            String ngayKT = request.getParameter("ngayKetThuc");
            System.out.println(ngayBD + "  " + ngayKT);

            // tim kiem all
            if (ngayBD.equals("") & ngayKT.equals("")) {
                request.setAttribute("listHD", repo.getHD());
                request.setAttribute("mess", "");

            }
            // tim kiem 1 ngay
            if (ngayKT.equals("") && !ngayBD.equals("")) {
                request.setAttribute("listHD", repo.timKiemTuNgay(Date.valueOf(ngayBD)));
                request.setAttribute("mess", "Từ Ngày " + ngayBD);
            }
            // tim kiem khoang ngay
            if (!ngayKT.equals("") && !ngayBD.equals("")) {
                request.setAttribute("listHD", repo.timKiemTheoKhoang(Date.valueOf(ngayBD), Date.valueOf(ngayKT)));
                request.setAttribute("mess", "Từ Ngày " + ngayBD + " Đến Ngày " + ngayKT);
            }
            request.getRequestDispatcher("/view/hoadon/homeHD.jsp").forward(request, response);
        }
    }
}
