package com.example.asm.controller;


import com.example.asm.model.CTSP;
import com.example.asm.responsitory.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/homeCTSP",
        "/detailCTSP",
        "/addCTSP",
        "/updateCTSP",
        "/deleteCTSP",
        "/timKiemTheoKhoang",
        "/searchTheoSelect"
})
public class SanPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CTSPResponsitory ctspR = new CTSPResponsitory();
        SanPhamResponsitory spR = new SanPhamResponsitory();
        NSXResponsitory nsxR = new NSXResponsitory();
        MauSacResponsitory msR = new MauSacResponsitory();
        DongSPResponsitory dongspR = new DongSPResponsitory();

        String uri = request.getRequestURI();
        if (uri.contains("/homeCTSP")) {
            ArrayList<CTSP> list = ctspR.getCTSP();
            request.setAttribute("listCTSP", list);
            request.setAttribute("listSP", spR.getSP());
            request.setAttribute("listNSX", nsxR.getNSX());
            request.setAttribute("listMS", msR.getMS());
            request.setAttribute("listDongSP", dongspR.getDongSP());
            request.getRequestDispatcher("/view/ctsp/trangchuCTSP.jsp").forward(request, response);
        } else if (uri.equals("/detailCTSP")) {

            String id = request.getParameter("id");
            CTSP ctsp = ctspR.getbyID(id);
            request.setAttribute("ctsp", ctsp);
            request.setAttribute("listSP", spR.getSP());
            request.setAttribute("listNSX", nsxR.getNSX());
            request.setAttribute("listMS", msR.getMS());
            request.setAttribute("listDongSP", dongspR.getDongSP());
            request.getRequestDispatcher("/view/ctsp/detailCTSP.jsp").forward(request, response);
        } else if (uri.contains("/deleteCTSP")) {
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            CTSP ctsp = ctspR.getbyID(id);
            ;
            ctspR.delete(ctsp);

            // dieu hướng
            response.sendRedirect("/homeCTSP");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CTSPResponsitory ctspR = new CTSPResponsitory();
        SanPhamResponsitory spR = new SanPhamResponsitory();
        NSXResponsitory nsxR = new NSXResponsitory();
        MauSacResponsitory msR = new MauSacResponsitory();
        DongSPResponsitory dongSPR = new DongSPResponsitory();

        String uri = request.getRequestURI();
        if (uri.contains("/addCTSP")) {
            CTSP ctsp = new CTSP();
            try {
                String idSP = request.getParameter("idsp");
                String idNSX = request.getParameter("idnsx");
                String idMS = request.getParameter("idms");
                String idDSP = request.getParameter("iddsp");

                BeanUtils.populate(ctsp, request.getParameterMap());

                ctsp.setId(UUID.randomUUID().toString());
                ctsp.setIdSP(spR.getById(idSP));
                ctsp.setIdNSX(nsxR.findById(idNSX));
                ctsp.setIdMS(msR.findById(idMS));
                ctsp.setIdDongSP(dongSPR.getbyID(idDSP));

                ctspR.saveCTSP(ctsp);
                response.sendRedirect("/homeCTSP");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("/updateCTSP")) {

            String id = request.getParameter("id");
            String idSP = request.getParameter("idsp");
            String idNSX = request.getParameter("idnsx");
            String idMS = request.getParameter("idms");
            String idDSP = request.getParameter("iddsp");

            CTSP ctsp = ctspR.getbyID(id);
            if (ctsp != null) {
                // tien hanh update
                CTSP ctspN = new CTSP();
                try {

                    BeanUtils.populate(ctspN, request.getParameterMap());

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                ctspN.setId(ctsp.getId()); // lay id
                ctspN.setIdSP(spR.getById(idSP));
                ctspN.setIdNSX(nsxR.findById(idNSX));
                ctspN.setIdMS(msR.findById(idMS));
                ctspN.setIdDongSP(dongSPR.getbyID(idDSP));


                ctspR.updateCTSP(ctspN);


                System.out.println("Update thanh cong");
                response.sendRedirect("/homeCTSP");
            } else {
                System.out.println("Khong tim thay");
            }
        }else if(uri.contains("/timKiemTheoKhoang")){
            String tim = request.getParameter("timKiemTheoKhoang");
            if(tim==null|tim.equals("")){
                // tra ve list ban dau
                ArrayList<CTSP> list = ctspR.getCTSP();
                request.setAttribute("listCTSP", list);
            }else {

                ArrayList<CTSP> list = ctspR.timKiem(tim);
                request.setAttribute("listCTSP", list);
                request.setAttribute("dulieu",tim);

            }
            request.getRequestDispatcher("/view/ctsp/trangchuCTSP.jsp").forward(request, response);
        }else if(uri.contains("/searchTheoSelect")){

            String id = request.getParameter("timKiemtheoDTuong");
            if(id==null|id.equals("")){
                // tra ve list ban dau
                ArrayList<CTSP> list = ctspR.getCTSP();
                request.setAttribute("listCTSP", list);
                request.setAttribute("listSP", spR.getSP());
            }else {

                ArrayList<CTSP> list = ctspR.timKiemtheoSelect(id);
                request.setAttribute("listCTSP", list);
                request.setAttribute("listSP", spR.getSP());
                request.setAttribute("dulieu",id);

            }
            request.getRequestDispatcher("/view/ctsp/trangchuCTSP.jsp").forward(request, response);
        }

    }
}
