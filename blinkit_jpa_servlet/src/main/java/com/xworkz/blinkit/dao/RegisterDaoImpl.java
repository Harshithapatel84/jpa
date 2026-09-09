package com.xworkz.blinkit.dao;

import com.xworkz.blinkit.entity.RegisterEntity;

import javax.persistence.*;

public class RegisterDaoImpl implements RegisterDao{

    public  static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("register");
    @Override
    public boolean save(RegisterEntity entity) {
        System.out.println("invokins save:regiaterDaoImpl");
        boolean isSaved=false;
        EntityManager em=null;
        EntityTransaction et=null;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            em.persist(entity);
            isSaved=true;
            et.commit();

        }catch (PersistenceException e){
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
            isSaved = false;
        }
        finally {
            if(em!=null){
                em.close();
            }
        }

        return isSaved;
    }
}
