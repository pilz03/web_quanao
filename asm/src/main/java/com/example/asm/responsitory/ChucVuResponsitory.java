package com.example.asm.responsitory;

import com.example.asm.model.ChucVu;
import com.example.asm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChucVuResponsitory {
    private final Session s = HibernateUtils.getFACTORY().openSession();

    public ArrayList<ChucVu> getCV() {
        String sql = "select c from ChucVu as c";
        Query q = s.createQuery(sql);
        ArrayList<ChucVu> liCV = new ArrayList<>();
        liCV = (ArrayList<ChucVu>) q.getResultList();
        return liCV;
    }

    //them
    public boolean addCV(ChucVu chucVu) {
        try {
            s.getTransaction().begin();
            s.save(chucVu);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    // update
    public boolean updateCV(ChucVu chucVu) {
        ChucVu cv = s.get(ChucVu.class,chucVu.getId());
        System.out.println(cv);
        if(cv==null){
            return false;
        }
        //update
        cv.setMa(chucVu.getMa());
        cv.setTen(chucVu.getTen());

        s.getTransaction().begin();
        s.update(cv);
        s.getTransaction().commit();
        return true;

    }

    // xoa
    public boolean deleteCV(ChucVu chucVu) {
        ChucVu cv = s.get(ChucVu.class,chucVu.getId());

        if(cv==null){
            return false;
        }


        s.getTransaction().begin();
        s.delete(cv);
        s.getTransaction().commit();
        return true;

    }
    public ChucVu findById(String id){
        ChucVu cv = s.get(ChucVu.class,id);
        return cv;
    }
    public static void main(String[] args) {
        ChucVuResponsitory cvR = new ChucVuResponsitory();

//        ChucVu c1 = new ChucVu(UUID.randomUUID().toString(), "QL1", "Quản lý");
//        ChucVu c1 = new ChucVu("76EE738F-93E1-4A2E-94A8-A8F080A4781A", "QL1", "Quản lý");
       System.out.println(cvR.findById("2871F813-1B1F-4E4F-92D1-0685E7F07E43"));
        System.out.println(cvR.getCV());

    }
}
