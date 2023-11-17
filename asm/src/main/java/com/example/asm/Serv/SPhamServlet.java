package com.example.asm.controller;

import com.example.asm.model.SanPham;
import com.example.asm.responsitory.SanPhamResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "SPhamServlet", value = {
        "/homeSP",
        "/detailSP",
        "/addSP",
        "/updateSP",
        "/deleteSP"
})
public class SPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SanPhamResponsitory spR = new SanPhamResponsitory();

        if (uri.contains("/homeSP")) {
            ArrayList<SanPham> list = spR.getSP();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/view/sanpham/trangchuSP.jsp").forward(request, response);
        } else if (uri.contains("/detailSP")) {
            String id = request.getParameter("id");
            SanPham sanPham = spR.getById(id);
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("/view/sanpham/detailSP.jsp").forward(request, response);
        }else if(uri.contains("/deleteSP")) {
            String id = request.getParameter("id");
            SanPham sp = spR.getById(id);
            spR.deleteSP(sp);
            response.sendRedirect("/homeSP");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SanPhamResponsitory spR = new SanPhamResponsitory();
        if(uri.contains("/addSP")){
            SanPham spS = new SanPham();
            try {
                BeanUtils.populate(spS, request.getParameterMap());
                spS.setId(UUID.randomUUID().toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            spR.saveSP(spS);
            response.sendRedirect("/homeSP");
        } else if (uri.contains("/updateSP")) {
            String id = request.getParameter("id");
            SanPham spOld = spR.getById(id);
            if(spOld != null){
                //tien hanh update
                SanPham spU = new SanPham();
                try {
                    BeanUtils.populate(spU, request.getParameterMap());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                spR.updateSP(spU);
                response.sendRedirect("/homeSP");
            }else {
                System.out.println("Khong tim thay");
            }
        }
    }
}
