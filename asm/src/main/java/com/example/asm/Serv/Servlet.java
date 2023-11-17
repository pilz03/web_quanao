package com.example.asm.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet", value = {"/home","/user/login"})
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("homeHD.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getRequestURI();
        if (p.contains("/user/login")) {
                String user = request.getParameter("ten");
                String pass = request.getParameter("pass");
                String check = request.getParameter("check");
            System.out.println(check);


                request.setAttribute("U",user);
                request.setAttribute("P",pass);
                request.setAttribute("C",check);
            request.getRequestDispatcher("/user.jsp").forward(request,response);
        }
    }
}
