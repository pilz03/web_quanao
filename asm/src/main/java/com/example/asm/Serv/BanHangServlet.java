package com.example.asm.controller;

import com.example.asm.model.CTSP;
import com.example.asm.responsitory.CTSPResponsitory;
import com.example.asm.responsitory.SanPhamResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BanHangServlet", value = {
        "/ban-hang/trang-chu",
        "/banhang/gioi-thieu"

})
public class BanHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        CTSPResponsitory ctspResponsitory = new CTSPResponsitory();
        if (uri.contains("/trang-chu")){
            ArrayList<CTSP> list = ctspResponsitory.getCTSP();
            request.setAttribute("listCTSP",list);
            request.getRequestDispatcher("/view/trangchu/home.jsp").forward(request,response);
        }else if(uri.contains("/banhang/gioi-thieu")){
            request.getRequestDispatcher("/view/trangchu/gioithieu.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
