package com.xworkz.book.dao.impl;

import com.xworkz.book.dao.RegisterDAO;
import com.xworkz.book.entity.RegisterEntity;

import javax.persistence.*;
import java.util.List;

public class RegisterDaoImpl implements RegisterDAO {

    @Override
    public Boolean save(RegisterEntity entity) {

        System.out.println("Invoking save RegisterDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        boolean isSaved = false;

        try {
            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
            et.commit();

            isSaved = true;

        } catch (PersistenceException e) {

            e.printStackTrace();

            if (et != null && et.isActive()) {
                et.rollback();
            }

            isSaved = false;

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return isSaved;
    }

    @Override
    public Boolean saveAll(List<RegisterEntity> registerEntityList) {

        System.out.println("Invoking saveAll RegisterDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (RegisterEntity entity : registerEntityList) {
                em.persist(entity);
            }

            et.commit();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            if (et != null && et.isActive()) {
                et.rollback();
            }

            return false;

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }

    @Override
    public RegisterEntity getRegisterEntityById(Integer bookId) {

        System.out.println("Invoking getRegisterEntityById : RegisterDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            RegisterEntity entity =
                    em.find(RegisterEntity.class, bookId);

            return entity;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

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