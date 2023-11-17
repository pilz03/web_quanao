package com.example.asm.responsitory;


import com.example.asm.model.CTSP;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CTSPResponsitory {
    public ArrayList<CTSP> getCTSP() {
        ArrayList<CTSP> list = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            list = (ArrayList<CTSP>) session.createQuery(" FROM CTSP ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public CTSP getbyID(String id) {
        CTSP cv = new CTSP();
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            cv = s.get(CTSP.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    public Boolean saveCTSP(CTSP cv) {
        Transaction tr = null;
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            tr = s.beginTransaction();
//            UUID id = UUID.randomUUID();
//            cv.setId(id);
            s.save(cv);
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

    public Boolean updateCTSP(CTSP cv) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(cv);
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
    public Boolean delete(CTSP cv) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cv);
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
    public ArrayList<CTSP> timKiem(String timKiem) {
        ArrayList<CTSP> list = new ArrayList<>();
        String hql = "select ctsp from CTSP  as ctsp where ctsp.idSP.ten like :timTen";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {

            Query query = session.createQuery(hql);
            query.setParameter("timTen","%"+timKiem+ "%");
            list = (ArrayList<CTSP>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CTSP> timKiemtheoSelect(String id  ) {
        ArrayList<CTSP> list = new ArrayList<>();
        String hql = "select ctsp from CTSP  as ctsp where ctsp.idSP.id= :timDoiTuong";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {

            Query query = session.createQuery(hql);
            query.setParameter("timDoiTuong",id);
            list = (ArrayList<CTSP>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
