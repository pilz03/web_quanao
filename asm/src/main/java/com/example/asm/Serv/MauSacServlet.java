package com.example.asm.controller;

import com.example.asm.model.MauSac;
import com.example.asm.responsitory.MauSacResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/homeMS", // get
        "/detail", // get
        "/form-add", // get
        "/add" ,//post
        "/delete", // get
        "/form-update", //get
        "/update" // post

})
public class MauSacServlet extends HttpServlet {
    private final MauSacResponsitory mR = new MauSacResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();


        if(uri.contains("/homeMS")) {
//           1:  day du lieu

            ArrayList<MauSac> list = mR.getMS();
            //
            request.setAttribute("liMS", list);
            request.getRequestDispatcher("/view/mausac/home.jsp").forward(request, response);

            // 2 :hien detail
        }else if(uri.contains("/detail")){
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            MauSac ms = mR.findById(id);
            request.setAttribute("mS",ms);
            request.getRequestDispatcher("/view/mausac/detail.jsp").forward(request,response);

            // 3 : mo ra form add
        }else if(uri.contains("/form-add")){
            request.getRequestDispatcher("/view/mausac/add.jsp").forward(request,response);

            // 4 : xoa
        }else if(uri.contains("/delete")) {
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            MauSac ms = mR.findById(id);
           Boolean check= mR.deleteMS(ms);
           if(check){
               request.setAttribute("mess","Xoa thanh cong !");
           }
           // trả lai list kem theo mess
            ArrayList<MauSac> list = mR.getMS();
            //
            request.setAttribute("liMS", list);
            // dieu hướng
            request.getRequestDispatcher("/view/mausac/homeHD.jsp").forward(request, response);

            // 5: mo ra form update
        }else if(uri.contains("/form-update")) {
            // lay id
            String id = request.getParameter("id");
            // lay doi tuong tu id
            MauSac ms = mR.findById(id);
            request.setAttribute("mS",ms);

            request.getRequestDispatcher("/view/mausac/update.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        // 6 : add
        if(uri.contains("/add")) {

          String ma = request.getParameter("ma");
          String ten = request.getParameter("ten");

          MauSac ms = new MauSac(UUID.randomUUID().toString(),ma,ten);

         Boolean check = mR.addMS(ms);
            System.out.println(check);
          response.sendRedirect("/homeMS");



        // update
        }else if(uri.contains("/update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            MauSac ms = new MauSac(id,ma,ten);

            Boolean check = mR.updateMS(ms);
            System.out.println(check);
            response.sendRedirect("/homeMS");
        }
    }
}
