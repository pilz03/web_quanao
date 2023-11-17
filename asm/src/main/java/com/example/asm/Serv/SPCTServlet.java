package com.example.asm.controller;

import com.example.asm.responsitory.CTSPResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SPServlet", value = {
        "/sanpham/detail"
})
public class SPCTServlet extends HttpServlet {
    private CTSPResponsitory ctspResponsitory = new CTSPResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sanpham/detail")) {
            String id = request.getParameter("id");
            request.setAttribute("product", ctspResponsitory.getbyID(id));
            request.getRequestDispatcher("/view/trangchu/detailSP.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
