package com.example.asm.responsitory;

import com.example.asm.model.GioHang;
import com.example.asm.model.GioHang;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class GioHangResponsitory {
    public ArrayList<GioHang> getGH(){
        ArrayList<GioHang> list = new ArrayList<>();
        try(Session session = HibernateUtils.getFACTORY().openSession()) {
            list= (ArrayList<GioHang>) session.createQuery("from GioHang ").list();


        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public GioHang getById(String id){
        GioHang gh = new GioHang();
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            gh=session.get(GioHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return gh;
    }

    public Boolean saveGH(GioHang gh){
        Transaction transaction =null;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(gh);
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
    public Boolean updateGH(GioHang gh){
        Transaction transaction =null;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(gh);
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
