package com.example.asm.controller;

import com.example.asm.model.ChucVu;
import com.example.asm.model.MauSac;
import com.example.asm.responsitory.ChucVuResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/homeCV",//get
        "/detailCV", // get
        "/form-addCV", // get
        "/addCV" , // post
        "/form-updateCV", // get
        "/updateCV", // post
        "/deleteCV" // get
})
public class ChucVuServlet extends HttpServlet {
    private final ChucVuResponsitory cvR = new ChucVuResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/homeCV")) {
            ArrayList<ChucVu> list = cvR.getCV();

            request.setAttribute("listCV",list);
            request.getRequestDispatcher("/view/chucvu/home.jsp").forward(request,response);
        }else if(uri.contains("/detailCV")){
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            ChucVu cv = cvR.findById(id);
            request.setAttribute("cV",cv);
            request.getRequestDispatcher("/view/chucvu/detail.jsp").forward(request,response);
        }else if(uri.contains("/form-addCV")){
            request.getRequestDispatcher("/view/chucvu/add.jsp").forward(request,response);
        }else if(uri.contains("/form-updateCV")){
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            ChucVu cv = cvR.findById(id);
            request.setAttribute("cV",cv);

            request.getRequestDispatcher("/view/chucvu/update.jsp").forward(request, response);
        }else if(uri.contains("/deleteCV")) {
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            ChucVu cv = cvR.findById(id);
            Boolean check= cvR.deleteCV(cv);
            if(check){
                request.setAttribute("mess","Xoa thanh cong !");
            }
            // trả lai list kem theo mess
            ArrayList<ChucVu> list = cvR.getCV();
            //
            request.setAttribute("listCV", list);
            // dieu hướng
            request.getRequestDispatcher("/view/chucvu/home.jsp").forward(request, response);


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        // 6 : add
        if(uri.contains("/addCV")) {

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            ChucVu ms = new ChucVu(UUID.randomUUID().toString(),ma,ten);

            Boolean check = cvR.addCV(ms);
            System.out.println(check);
            response.sendRedirect("/homeCV");



            // update
        }else if(uri.contains("/updateCV")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            ChucVu cv = new ChucVu(id,ma,ten);

            Boolean check = cvR.updateCV(cv);
            System.out.println(check);
            response.sendRedirect("/homeCV");
        }
    }
}
