package com.example.asm.responsitory;


import com.example.asm.model.HoaDon;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;

public class HoaDonResponsitory {
    public ArrayList<HoaDon> getHD() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<HoaDon>) session.createQuery("from HoaDon ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public HoaDon getbyID(String id) {
        HoaDon hd = new HoaDon();
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            hd = s.get(HoaDon.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    public Boolean save(HoaDon hd) {
        Transaction tr = null;
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            tr = s.beginTransaction();

            s.save(hd);
            tr.commit();
            return true;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateHD(HoaDon kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(kh);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<HoaDon> timKiemTheoKhoang(Date ngayBD , Date ngayKT){
        ArrayList<HoaDon> list = new ArrayList<>();
        String hql = "SELECT hd FROM HoaDon as hd WHERE hd.ngayTao BETWEEN :ngayBD AND :ngayKT";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {

            Query query = session.createQuery(hql);
            query.setParameter("ngayBD",ngayBD);
            query.setParameter("ngayKT",ngayKT);
            list = (ArrayList<HoaDon>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> timKiemTuNgay(Date ngay){
        ArrayList<HoaDon> list = new ArrayList<>();
        String hql = "SELECT hd FROM HoaDon as hd WHERE hd.ngayTao >= :ngay";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {

            Query query = session.createQuery(hql);
            query.setParameter("ngay",ngay);

            list = (ArrayList<HoaDon>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        HoaDonResponsitory hdR = new HoaDonResponsitory();
        Date ngayBD = Date.valueOf("2023-02-01");
        Date ngayKT = Date.valueOf("2023-02-10");
        Date ngay = Date.valueOf("2023-02-07");
        System.out.println(hdR.timKiemTheoKhoang(ngayBD,ngayKT));
        System.out.println(hdR.timKiemTuNgay(ngay));

    }
}
