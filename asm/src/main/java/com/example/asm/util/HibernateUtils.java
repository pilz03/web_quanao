package com.example.asm.util;

import com.example.asm.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    private final static SessionFactory sF ;
    static {
        // cau hinh
        Configuration c = new Configuration();

        // thuoc tinh
        Properties p = new Properties();
        p.put(Environment.DIALECT,"org.hibernate.dialect.SQLServerDialect");
        p.put(Environment.DRIVER,"com.microsoft.sqlserver.jdbc.SQLServerDriver");
        p.put(Environment.URL,"jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;");
        p.put(Environment.USER,"sa");
        p.put(Environment.PASS,"123456");

        c.setProperties(p);
        c.addAnnotatedClass(CuaHang.class);
        c.addAnnotatedClass(ChucVu.class);
        c.addAnnotatedClass(NSX.class);
        c.addAnnotatedClass(MauSac.class);
        c.addAnnotatedClass(DongSP.class);
        c.addAnnotatedClass(SanPham.class);
        c.addAnnotatedClass(CTSP.class);
        c.addAnnotatedClass(HoaDon.class);
        c.addAnnotatedClass(KhachHang.class);
        c.addAnnotatedClass(NhanVien.class);
        c.addAnnotatedClass(GioHang.class);

        c.addAnnotatedClass(GioHangChiTiet.class);
        c.addAnnotatedClass(HoaDonChiTiet.class);

        //
        ServiceRegistry s = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        sF = c.buildSessionFactory(s);

    }
    public static SessionFactory getFACTORY(){
        return sF;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
