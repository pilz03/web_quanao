package com.example.asm.controller;


import com.example.asm.model.NhanVien;
import com.example.asm.responsitory.ChucVuResponsitory;
import com.example.asm.responsitory.NhanVienResponsitory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/homeNV",
        "/detailNV",
        "/saveNV",
        "/updateNV"
})
public class NhanVienServlet extends HttpServlet {
    private final NhanVienResponsitory nvR = new NhanVienResponsitory();
    private final ChucVuResponsitory cvR = new ChucVuResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        // Đối vs các dự liệu từ các bảng phụ thì load đối tượng của các bảng để làm :
        // tìm kiếm theo chức vụ , san phảm ...
        // thêm vào các bảng cần id của các bảng phụ : laod dữ liệu vào select<option>
        //...
        if(uri.contains("homeNV")){
            ArrayList<NhanVien> list = nvR.getNV();
            request.setAttribute("listNV",list);
            request.setAttribute("listCV",cvR.getCV());
            request.getRequestDispatcher("/view/nhanvien/trangchuNV.jsp").forward(request,response);
        }else if(uri.contains("detailNV")){
            String id = request.getParameter("id");
            NhanVien nv = nvR.getbyID(id);
            request.setAttribute("nv",nv);
            request.setAttribute("listCV",cvR.getCV());
            request.getRequestDispatcher("/view/nhanvien/detailNV.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVienResponsitory nvR = new NhanVienResponsitory();
        ChucVuResponsitory cvR = new ChucVuResponsitory();
        String uri = request.getRequestURI();
        if(uri.contains("saveNV")){
            NhanVien nv = new NhanVien();
            try {
                // get id Cv từ form
                String idCV = request.getParameter("idcv");

                // đẩy dữ liệu vào vào đối tượng
                BeanUtils.populate(nv,request.getParameterMap());

                nv.setId(UUID.randomUUID().toString());
                nv.setIdCV(cvR.findById(idCV));

              // save database
                nvR.save(nv);
                System.out.println(nv);
                response.sendRedirect("/homeNV");
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (uri.contains("updateNV")) {
            String id = request.getParameter("id");
            // get id Cv từ form
            String idCV = request.getParameter("idcv");
            NhanVien nv = nvR.getbyID(id);
            if(nv != null){
                try {
                    // đẩy dữ liệu vào vào đối tượng
                    BeanUtils.populate(nv,request.getParameterMap());
//                    nv.setId(nv.getId()); // lay id
                    nv.setIdCV(cvR.findById(idCV));
                    // save database
                    nvR.updateNV(nv);
                    response.sendRedirect("/homeNV");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
