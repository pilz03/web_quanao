package com.example.asm.responsitory;

import com.example.asm.model.NhanVien;

import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class NhanVienResponsitory {
    public ArrayList<NhanVien> getNV() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<NhanVien>) session.createQuery("from NhanVien ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getbyID(String id) {
        NhanVien nv = new NhanVien();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            nv = session.get(NhanVien.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public Boolean save(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nv);
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

    public Boolean updateNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(nv);
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

    public Boolean deleteNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nv);
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

    public static void main(String[] args) {
        NhanVienResponsitory nvR = new NhanVienResponsitory();
        System.out.println(nvR.getbyID("24BF671E-348B-413C-BB24-A3FB5B80170C"));
    }
}
