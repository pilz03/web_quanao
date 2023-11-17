package com.example.asm.responsitory;


import com.example.asm.model.CuaHang;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class CuaHangResponsitory {
    public ArrayList<CuaHang> getCH() {
        ArrayList<CuaHang> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<CuaHang>) session.createQuery("from CuaHang ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public CuaHang getbyID(String id) {
        CuaHang ch = new CuaHang();
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            ch = s.get(CuaHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    public Boolean save(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ch);
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

    public Boolean updateCH(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ch);
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

    public Boolean deleteCH(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ch);
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
        CuaHangResponsitory chR = new CuaHangResponsitory();
        System.out.println(chR.getCH());
    }
}
