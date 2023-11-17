package com.example.asm.controller;

import com.example.asm.model.*;
import com.example.asm.responsitory.CTSPResponsitory;
import com.example.asm.responsitory.HoaDonChiTietResponsitory;
import com.example.asm.responsitory.HoaDonResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "GioHangServlet", value = {
        "/addToCart",
        "/editquantity",
        "/thanhtoan",
        "/xacnhan",
        "/gio-hang/xoa"
})
public class GioHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/addToCart")) {
            CTSPResponsitory ctspResponsitory = new CTSPResponsitory();
            HttpSession session = request.getSession();
            String id = request.getParameter("id");
            CTSP ctsp = ctspResponsitory.getbyID(id);
            CartItem cartItem = new CartItem();
            cartItem.setIdSp(ctsp.getId());
            cartItem.setTenSp(ctsp.getIdSP().getTen());
            cartItem.setGiaBan(ctsp.getGiaBan());
            cartItem.setSoLuong(1);
            cartItem.setAnh(ctsp.getAnh());
            Integer size = 0;
            double tongTien = 0;
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                Cart cartTmp = new Cart();
                List<CartItem> listCartItem = new ArrayList<>();
                listCartItem.add(cartItem);
                cartTmp.setList(listCartItem);
                for (CartItem cartItemTmp : cartTmp.getList()) {
                    size += cartItemTmp.getSoLuong();
                    tongTien += cartItemTmp.getSoLuong() * cartItemTmp.getGiaBan().doubleValue();
                }
                session.setAttribute("cart", cartTmp);

            } else {

                List<CartItem> list = cart.getList();

                Boolean check = false;
                for (CartItem cartItemTmp : list) {

                    if (cartItemTmp.getIdSp().equals(cartItem.getIdSp())) {
                        cartItemTmp.setSoLuong(cartItemTmp.getSoLuong() + 1);
                        check = true;

                    }

                }
                if (!check) {
                    list.add(cartItem);
                }
                cart.setList(list);
                for (CartItem cartItemTmp : cart.getList()) {
                    size += cartItemTmp.getSoLuong();
                    tongTien += cartItemTmp.getSoLuong() * cartItemTmp.getGiaBan().doubleValue();


                }
                session.setAttribute("cart", cart);
            }
            if (cart != null) {
                cart.getList().forEach(x -> System.out.println(x.toString()));
            }
            List<CartItem> list = ((Cart) session.getAttribute("cart")).getList();
//        System.out.println(list);
            request.setAttribute("size", size);
            request.setAttribute("tongTien", tongTien);
            request.setAttribute("listSP", list);
            request.getRequestDispatcher("/view/trangchu/giohang.jsp").forward(request, response);


        } else if (uri.contains("/editquantity")) {
            HttpSession session = request.getSession();

            String id = request.getParameter("id");
            Integer num = Integer.valueOf(request.getParameter("num"));
            Integer size = 0;
            double tongTien = 0;
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> list = cart.getList();
            for (CartItem cartItemTmp : list) {


                if (cartItemTmp.getIdSp().equals(id)) {

                    if (cartItemTmp.getSoLuong() > 1) {

                        cartItemTmp.setSoLuong(cartItemTmp.getSoLuong() + num);

                    } else {
                        if (num == 1) {
                            cartItemTmp.setSoLuong(cartItemTmp.getSoLuong() + num);

                        }

                    }


                }
                size += cartItemTmp.getSoLuong();
                tongTien += cartItemTmp.getSoLuong() * cartItemTmp.getGiaBan().doubleValue();

            }

            cart.setList(list);
            session.setAttribute("cart", cart);

            List<CartItem> listC = ((Cart) session.getAttribute("cart")).getList();
            request.setAttribute("listSP", listC);
            request.setAttribute("size", size);
            request.setAttribute("tongTien", tongTien);
            request.getRequestDispatcher("/view/trangchu/giohang.jsp").forward(request, response);
        }else if(uri.contains("/thanhtoan")){
            request.getRequestDispatcher("/view/hoadon/thanhtoanHD.jsp").forward(request, response);
        }else if(uri.contains("/gio-hang/xoa")){
            // lay id
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            Integer size = 0;
            double tongTien = 0;
            List<CartItem> listC = ((Cart) session.getAttribute("cart")).getList();
            CartItem cN = new CartItem();
            for (CartItem c : listC){
                if(c.getIdSp().equals(id)){
                     cN=c;
                }
                size += c.getSoLuong();
                tongTien += c.getSoLuong() * c.getGiaBan().doubleValue();
            }
            
            listC.remove(cN);
            List<CartItem> list = ((Cart) session.getAttribute("cart")).getList();
            request.setAttribute("listSP", list);
            request.setAttribute("size", size);
            request.setAttribute("tongTien", tongTien);
            request.getRequestDispatcher("/view/trangchu/giohang.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        HoaDonResponsitory hdR = new HoaDonResponsitory();
        HoaDonChiTietResponsitory hdctR = new HoaDonChiTietResponsitory();
        CTSPResponsitory ctspR = new CTSPResponsitory();

        if(uri.contains("/xacnhan")){
            String tenNguoiNhan = request.getParameter("ten");
            String sdt = request.getParameter("sdt");
            String dchi = request.getParameter("dchi");

            String idHD = UUID.randomUUID().toString();
            HoaDon hd = new HoaDon();
            hd.setTenNguoiNhan(tenNguoiNhan);
            hd.setSdt(sdt);
            hd.setDiaChi(dchi);
            hd.setNgayTao(new Date(System.currentTimeMillis()));
            hd.setNgayThanhToan(new Date(System.currentTimeMillis()));
            hd.setMa("HD"+System.currentTimeMillis());
            hd.setId(idHD);
            hd.setTinhTrang(1);

            hdR.save(hd);


            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> list = cart.getList();
            for (CartItem cartItem : list){
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setSoLuong(cartItem.getSoLuong());
                hdct.setDonGia(cartItem.getGiaBan());
                hdct.setIdChiTietSP(ctspR.getbyID(cartItem.getIdSp()));
                hdct.setIdHoaDon(hdR.getbyID(idHD));

                hdctR.save(hdct);
            }
            ArrayList<CartItem> list2= new ArrayList<>();
            cart.setList(list2);
            session.setAttribute("cart", cart);
                response.sendRedirect("/ban-hang/trang-chu");
        }
    }
}
