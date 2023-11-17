package com.example.asm.controller;

import com.example.asm.model.DongSP;
import com.example.asm.responsitory.DongSPResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/homeDongSP",
        "/detailDongSP",
        "/addDongSP",
        "/updateDongSP",
        "/deleteDongSP"
})
public class DongSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        DongSPResponsitory dspR = new DongSPResponsitory();

        if (uri.contains("/homeDongSP")) {
            ArrayList<DongSP> list = dspR.getDongSP();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/view/dongsp/trangchuDSP.jsp").forward(request, response);
        } else if (uri.contains("/detailDongSP")) {
            String id = request.getParameter("id");
            DongSP dongSP = dspR.getbyID(id);
            request.setAttribute("dongSP", dongSP);
            request.getRequestDispatcher("/view/dongsp/detailDSP.jsp").forward(request, response);
        }else if(uri.contains("/deleteDongSP")) {
            String id = request.getParameter("id");
            DongSP dongSP = dspR.getbyID(id);
            dspR.deleteDongSP(dongSP);
            response.sendRedirect("/homeDongSP");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        DongSPResponsitory dspR = new DongSPResponsitory();
        if(uri.contains("/addDongSP")){
            DongSP dongSP = new DongSP();
            try {
                BeanUtils.populate(dongSP, request.getParameterMap());
                dongSP.setId(UUID.randomUUID().toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            dspR.save(dongSP);
            response.sendRedirect("/homeDongSP");
        } else if (uri.contains("/updateDongSP")) {
            String id = request.getParameter("id");
            DongSP dspOld = dspR.getbyID(id);
            if(dspOld != null){
                //tien hanh update
                DongSP dongSP = new DongSP();
                try {
                    BeanUtils.populate(dongSP, request.getParameterMap());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                dspR.updateDongSP(dongSP);
                response.sendRedirect("/homeDongSP");
            }else {
                System.out.println("Khong tim thay");
            }
        }
    }
}
