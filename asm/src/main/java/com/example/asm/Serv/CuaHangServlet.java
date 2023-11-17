package com.example.asm.controller;

import com.example.asm.model.CuaHang;
import com.example.asm.responsitory.CuaHangResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/homeCH",
        "/detailCH",
        "/addCH",
        "/updateCH",
        "/deleteCH"
})
public class CuaHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        CuaHangResponsitory chR = new CuaHangResponsitory();

        if (uri.contains("/homeCH")) {
            ArrayList<CuaHang> list = chR.getCH();
            request.setAttribute("listCH", list);
            request.getRequestDispatcher("/view/cuahang/trangchuCH.jsp").forward(request, response);
        } else if (uri.contains("/detailCH")) {
            String id = request.getParameter("id");
            CuaHang ch = chR.getbyID(id);
            request.setAttribute("ch", ch);
            request.getRequestDispatcher("/view/cuahang/detailCH.jsp").forward(request, response);
        }else if(uri.contains("/deleteCH")) {
            String id = request.getParameter("id");
            CuaHang ch = chR.getbyID(id);
            chR.deleteCH(ch);
            response.sendRedirect("/homeCH");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        CuaHangResponsitory chR = new CuaHangResponsitory();
        if(uri.contains("/addCH")){
            CuaHang ch = new CuaHang();
            try {
                BeanUtils.populate(ch, request.getParameterMap());
                ch.setId(UUID.randomUUID().toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            chR.save(ch);
            response.sendRedirect("/homeCH");
        } else if (uri.contains("/updateCH")) {
            String id = request.getParameter("id");
            CuaHang chOld = chR.getbyID(id);
            if(chOld != null){
                //tien hanh update
                CuaHang ch = new CuaHang();
                try {
                    BeanUtils.populate(ch, request.getParameterMap());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                chR.updateCH(ch);
                response.sendRedirect("/homeCH");
            }else {
                System.out.println("Khong tim thay");
            }
        }
    }
}
