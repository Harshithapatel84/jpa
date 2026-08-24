package com.xworkz.redbus.runner;


import com.xworkz.redbus.entity.SignInEntity;

import javax.persistence.*;

public class CreateSignIn {

    public static void main(String[] args) {

        SignInEntity entity = new SignInEntity();

        entity.setEmail("akshay@gmail.com");
        entity.setName("Akshay");
        entity.setPhoneNumber(9632336136L);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();

            System.out.println("Data saved successfully:" +entity);


        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }
}

