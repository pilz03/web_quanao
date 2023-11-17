package com.example.asm.responsitory;

import com.example.asm.model.NSX;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NSXResponsitory {
    private final Session s = HibernateUtils.getFACTORY().openSession();
    public ArrayList<NSX> getNSX() {
        String sql = "select n from NSX as n";
        Query q = s.createQuery(sql);
        ArrayList<NSX> liNSX = new ArrayList<>();
        liNSX = (ArrayList<NSX>) q.getResultList();
        return liNSX;
    }

    //them
    public boolean addNSX(NSX nsx) {
        try {
            s.getTransaction().begin();
            s.save(nsx);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    // update
    public boolean updateNSX(NSX nsx) {
        NSX n1 = s.get(NSX.class,nsx.getId());

        if(n1==null){
            return false;
        }
        //update
        n1.setMa(nsx.getMa());
        n1.setTen(nsx.getTen());

        s.getTransaction().begin();
        s.update(n1);
        s.getTransaction().commit();
        return true;

    }

    // xoa
    public boolean deleteNSX(NSX nsx) {
        NSX nsx1 = s.get(NSX.class,nsx.getId());

        if(nsx1==null){
            return false;
        }


        s.getTransaction().begin();
        s.delete(nsx1);
        s.getTransaction().commit();
        return true;

    }

    public NSX findById(String id){
        NSX nsx = s.get(NSX.class,id);
        return nsx;
    }

    public static void main(String[] args) {
        NSXResponsitory cvR = new NSXResponsitory();

//    NSX c1 = new NSX(UUID.randomUUID().toString(), "QL1", "Quản lý");
        NSX c1 = new NSX(UUID.randomUUID().toString(), "QL1888", "Quản lý");
        System.out.println(cvR.addNSX(c1));
       // System.out.println(cvR.deleteNSX(c1));
        System.out.println(cvR.getNSX());
    }
}
