package com.example.asm.controller;

import com.example.asm.model.NSX;
import com.example.asm.responsitory.NSXResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/homeNSX",//get
        "/detailNSX",//get
        "/deleteNSX",//get
        "/form-addNSX",//get
        "/form-updateNSX",//get
        "/addNSX", //post
        "/updateNSX",//post

})
public class NSXServlet extends HttpServlet {
    private final NSXResponsitory nsxR = new NSXResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/homeNSX")) {
            ArrayList<NSX> list = nsxR.getNSX();
            request.setAttribute("listNSX", list);
            request.getRequestDispatcher("/view/nsx/home.jsp").forward(request, response);

        } else if (uri.contains("/detailNSX")) {
            String id = request.getParameter("id");
            NSX nsx = nsxR.findById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/nsx/detail.jsp").forward(request, response);
        } else if (uri.contains("/deleteNSX")) {
            String id = request.getParameter("id");
            NSX nsx = nsxR.findById(id);

            System.out.println(nsxR.deleteNSX(nsx));
            response.sendRedirect("/homeNSX");
        } else if (uri.contains("/form-addNSX")) {
            request.getRequestDispatcher("/view/nsx/add.jsp").forward(request, response);
        } else if (uri.contains("/form-updateNSX")) {
            String id = request.getParameter("id");
            NSX nsx = nsxR.findById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/nsx/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/addNSX")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX n = new NSX(UUID.randomUUID().toString(), ma, ten);

            nsxR.addNSX(n);
            response.sendRedirect("/homeNSX");
        }else if(uri.contains("/updateNSX")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            NSX n = new NSX(id,ma,ten);
            nsxR.updateNSX(n);
            response.sendRedirect("/homeNSX");
        }
    }
}
