package com.example.asm.responsitory;


import com.example.asm.model.SanPham;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamResponsitory {
    public ArrayList<SanPham> getSP(){
        ArrayList<SanPham> list = new ArrayList<>();
        try(Session session = HibernateUtils.getFACTORY().openSession()) {
            list= (ArrayList<SanPham>) session.createQuery("from SanPham ").list();


        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public SanPham getById(String id){
        SanPham sp = new SanPham();
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            sp=session.get(SanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sp;
    }

    public Boolean saveSP(SanPham sp){
        Transaction transaction =null;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();;
            }
            e.printStackTrace();
            return false;
        }

    }
    public Boolean updateSP(SanPham sp){
        Transaction transaction =null;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(sp);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();;
            }
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteSP(SanPham sp){
        Transaction transaction =null;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();;
            }
            e.printStackTrace();
            return false;
        }

    }
}
