package com.example.asm.controller;

import com.example.asm.model.KhachHang;
import com.example.asm.responsitory.KhachhangResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/homeKH",
        "/detailKH",
        "/addKH",
        "/updateKH",
        "/deleteKH"
})
public class KhachHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        KhachhangResponsitory khR = new KhachhangResponsitory();

        if (uri.contains("/homeKH")) {
            ArrayList<KhachHang> list = khR.getKH();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/view/khachhang/trangchuKH.jsp").forward(request, response);
        } else if (uri.contains("/detailKH")) {
            String id = request.getParameter("id");
            KhachHang kh = khR.getbyID(id);
            request.setAttribute("kh", kh);
            request.getRequestDispatcher("/view/khachhang/detailKH.jsp").forward(request, response);
        }else if (uri.contains("/deleteKH")) {
            String id = request.getParameter("id");
            KhachHang kh = khR.getbyID(id);
            khR.deleteKH(kh);
            response.sendRedirect("/homeKH");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        KhachhangResponsitory khR = new KhachhangResponsitory();
        if (uri.contains("/addKH")) {
            KhachHang kh = new KhachHang();
            try {
                // đẩy dữ liệu vào vào đối tượng
                BeanUtils.populate(kh, request.getParameterMap());
                kh.setId(UUID.randomUUID().toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            khR.save(kh);
            response.sendRedirect("/homeKH");
        } else if (uri.contains("/updateKH")) {
            String id = request.getParameter("id");
            KhachHang khOld = khR.getbyID(id);
            if (khOld != null) {
                //tien hanh update
                KhachHang kh = new KhachHang();
                try {
                    BeanUtils.populate(kh, request.getParameterMap());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                khR.updateKH(kh);
                response.sendRedirect("/homeKH");
            } else {
                System.out.println("Khong tim thay");
            }
        }
    }
}
