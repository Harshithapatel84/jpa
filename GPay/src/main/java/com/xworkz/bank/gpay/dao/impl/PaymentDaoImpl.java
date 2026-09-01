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
    public PaymentEntity getPaymentBySenderName(String senderName) {

        System.out.println("invoking getPaymentBySenderName");

        PaymentEntity paymentEntity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getPaymentBySenderName");
            query.setParameter("senderName", senderName);
            paymentEntity = (PaymentEntity) query.getSingleResult();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return paymentEntity;
    }
    @Override
    public PaymentEntity getPaymentByAmount(Double amount) {

        System.out.println("invoking getPaymentByAmount");

        PaymentEntity paymentEntity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getPaymentByAmount");

            query.setParameter("amount", amount);

            paymentEntity =
                    (PaymentEntity) query.getSingleResult();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return paymentEntity;
    }
    @Override
    public List<PaymentEntity> getPaymentBySenderNameAndAmount(String senderName, Double amount) {

        System.out.println("invoking getPaymentBySenderNameAndAmount");

        List<PaymentEntity> listOfEntity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getPaymentBySenderNameAndAmount");

            query.setParameter("senderName", senderName);
            query.setParameter("amount", amount);

            listOfEntity = query.getResultList();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return listOfEntity;
    }
    @Override
    public List<PaymentEntity> getPaymentBySenderNameOrAmount(String senderName, Double amount) {

        System.out.println("invoking getPaymentBySenderNameOrAmount");

        List<PaymentEntity> listOfEntity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getPaymentBySenderNameOrAmount");

            query.setParameter("senderName", senderName);
            query.setParameter("amount", amount);

            listOfEntity = query.getResultList();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return listOfEntity;
    }
    @Override
    public List<PaymentEntity> getPaymentByAmountGreaterThan(Double amount) {

        System.out.println("invoking getPaymentByAmountGreaterThan");

        List<PaymentEntity> listOfEntity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("gpay");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getPaymentByAmountGreaterThan");

            query.setParameter("amount", amount);

            listOfEntity = query.getResultList();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return listOfEntity;
    }

}

