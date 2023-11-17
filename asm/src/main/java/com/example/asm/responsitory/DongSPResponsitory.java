package com.example.asm.responsitory;

import com.example.asm.model.DongSP;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DongSPResponsitory {
    public ArrayList<DongSP> getDongSP() {
        ArrayList<DongSP> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<DongSP>) session.createQuery("from DongSP ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DongSP getbyID(String id) {
        DongSP dsp = new DongSP();
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            dsp = s.get(DongSP.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsp;
    }

    public Boolean save(DongSP dsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dsp);
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

    public Boolean updateDongSP(DongSP dsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(dsp);
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

    public Boolean deleteDongSP(DongSP dsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dsp);
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
