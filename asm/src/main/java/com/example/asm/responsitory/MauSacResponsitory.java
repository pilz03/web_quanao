package com.example.asm.responsitory;

import com.example.asm.model.MauSac;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class MauSacResponsitory {
    private final Session s = HibernateUtils.getFACTORY().openSession();
    public ArrayList<MauSac> getMS() {
        String sql = "select n from MauSac as n";
        Query q = s.createQuery(sql);
        ArrayList<MauSac> liMS = new ArrayList<>();
        liMS = (ArrayList<MauSac>) q.getResultList();
        return liMS;
    }

    //them
    public boolean addMS(MauSac ms) {
        try {
            s.getTransaction().begin();
            s.save(ms);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    // update
    public boolean updateMS(MauSac ms) {
        MauSac ms1 = s.get(MauSac.class, ms.getId());

        if(ms1==null){
            return false;
        }
        //update
        ms1.setMa(ms.getMa());
        ms1.setTen(ms.getTen());

        s.getTransaction().begin();
        s.update(ms1);
        s.getTransaction().commit();
        return true;

    }

    // xoa
    public boolean deleteMS(MauSac ms) {
        MauSac nsx1 = s.get(MauSac.class, ms.getId());

        if(nsx1==null){
            return false;
        }


        s.getTransaction().begin();
        s.delete(nsx1);
        s.getTransaction().commit();
        return true;

    }
    public MauSac findById(String id){
        MauSac ms = s.get(MauSac.class,id);
        return ms;
    }

    public static void main(String[] args) {
        MauSacResponsitory cvR = new MauSacResponsitory();

//    MauSac c1 = new MauSac(UUID.randomUUID().toString(), "QL1", "Quản lý");
        MauSac c1 = new MauSac("58535229-D1C9-4A7D-858B-F6E3CEF99550", "QL18881111", "Quản lý");
        System.out.println(cvR.deleteMS(c1));
        System.out.println(cvR.getMS());
    }
}
