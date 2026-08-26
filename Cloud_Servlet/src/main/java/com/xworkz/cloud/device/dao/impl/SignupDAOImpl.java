package com.xworkz.cloud.device.dao.impl;

import com.xworkz.cloud.device.dao.SignupDAO;
import com.xworkz.cloud.device.entity.SignupEntity;

import javax.persistence.*;

public class SignupDAOImpl implements SignupDAO {
    @Override
    public boolean save(SignupEntity entity) {
        System.out.println("invoking save signupImpl");
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        boolean isSaved = false;
        try {
            emf = Persistence.createEntityManagerFactory("cloud");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.persist(entity);

            isSaved = true;
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
            isSaved = false;
        } finally {
            if (emf != null) {
                emf.close();
            }
            if(em!=null){
                em.close();
            }
        }
        return isSaved;
    }
}

