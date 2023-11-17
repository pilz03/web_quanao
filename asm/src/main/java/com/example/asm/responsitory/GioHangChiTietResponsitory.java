package com.example.asm.responsitory;

import com.example.asm.model.GioHangChiTiet;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class GioHangChiTietResponsitory {
    public ArrayList<GioHangChiTiet> getGHCT(){
        ArrayList<GioHangChiTiet> list = new ArrayList<>();
        try(Session session = HibernateUtils.getFACTORY().openSession()) {
            list= (ArrayList<GioHangChiTiet>) session.createQuery("from GioHangChiTiet ").list();


        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public GioHangChiTiet getById(String id){
        GioHangChiTiet ghct = new GioHangChiTiet();
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            ghct=session.get(GioHangChiTiet.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ghct;
    }

    public Boolean saveGHCT(GioHangChiTiet sp){
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
    public Boolean updateGHCT(GioHangChiTiet sp){
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
}
