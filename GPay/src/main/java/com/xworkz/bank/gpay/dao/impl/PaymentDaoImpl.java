 package com.xworkz.bank.gpay.dao.impl;

import com.xworkz.bank.gpay.dao.PaymentDAO;
import com.xworkz.bank.gpay.entity.PaymentEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class PaymentDaoImpl implements PaymentDAO {


    @Override
    public boolean save(PaymentEntity entity) {
        System.out.println("invoking save : PaymentDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        boolean isSaved = false;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
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

            if (em != null) {
                em.close();
            }
        }

        return isSaved;
    }


    @Override
    public Boolean saveAll(List<PaymentEntity> list) {

        System.out.println("invoking saveAll : PaymentDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        Boolean isSaved = false;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (PaymentEntity entity : list) {
                em.persist(entity);
            }

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
    public PaymentEntity getById(Integer id) {

        System.out.println("Invoking getPaymentEntityById : PaymentDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();

            PaymentEntity entity =
                    em.find(PaymentEntity.class, id);

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


    @Override
    public List<PaymentEntity> readAllPaymentEntity() {

        System.out.println("invoking readAll : PaymentDAOImpl");

        List<PaymentEntity> paymentEntityList =
                Collections.emptyList();

        try {

            paymentEntityList = Persistence
                    .createEntityManagerFactory("gpay")
                    .createEntityManager()
                    .createNamedQuery("getAllPaymentEntity")
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + paymentEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return paymentEntityList;
    }

    @Override
    public List<PaymentEntity> getPaymentById(int id) {

        System.out.println(
                "invoking getPaymentById : PaymentDAOImpl");

        List<PaymentEntity> paymentEntityList =
                Collections.emptyList();

        try {

            paymentEntityList = Persistence
                    .createEntityManagerFactory("gpay")
                    .createEntityManager()
                    .createNamedQuery("getPaymentById")
                    .setParameter("id", id)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + paymentEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        }

        return paymentEntityList;
    }

    @Override
    public boolean updateByName(String senderName) {
        return false;
    }

    @Override
    public boolean updateSenderNameById(Integer id, String senderName) {
        return false;
    }

    @Override
    public boolean updateAmountById(Integer id, Double amount) {
        return false;
    }

    @Override
    public boolean deletePaymentById(Integer id) {
        return false;
    }

    @Override
    public boolean deletePaymentBySenderName(String senderName) {
        return false;
    }

}

