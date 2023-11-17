package com.example.asm.responsitory;

import com.example.asm.model.HoaDon;
import com.example.asm.model.HoaDonChiTiet;
import com.example.asm.util.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonChiTietResponsitory {
    public ArrayList<HoaDonChiTiet> getHDCT() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//
    // lay ra sphamct từ hoadonct thong qua idhoadon
    public ArrayList<HoaDonChiTiet> getbyHDCT(String id) {
        ArrayList<HoaDonChiTiet> lihdct = new ArrayList<>();
        String hql = "select hd from HoaDonChiTiet as hd where hd.IdHoaDon.id = :id";
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            Query query = s.createQuery(hql).setParameter("id", id);
            lihdct = (ArrayList<HoaDonChiTiet>) query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lihdct;
    }

    public Boolean save(HoaDonChiTiet hdct) {
        Transaction tr = null;
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            tr = s.beginTransaction();

            s.save(hdct);
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

    public static void main(String[] args) {
        HoaDonChiTietResponsitory hdctR = new HoaDonChiTietResponsitory();
        System.out.println(hdctR.getbyHDCT("26D802E7-DDF9-47EF-9C72-22DB4D0FB8CA"));
    }

}
