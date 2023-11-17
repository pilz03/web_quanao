package com.example.asm.responsitory;


import com.example.asm.model.KhachHang;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class KhachhangResponsitory {
    public ArrayList<KhachHang> getKH() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<KhachHang>) session.createQuery("from KhachHang ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang getbyID(String id) {
        KhachHang kh = new KhachHang();
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            kh = s.get(KhachHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public Boolean save(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(kh);
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

    public Boolean updateKH(KhachHang kh) {
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

    public Boolean deleteKH(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
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

}
