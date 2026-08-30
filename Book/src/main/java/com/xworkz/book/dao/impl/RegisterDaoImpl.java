package com.xworkz.book.dao.impl;

import com.xworkz.book.dao.RegisterDAO;
import com.xworkz.book.entity.RegisterEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class RegisterDaoImpl implements RegisterDAO {

    @Override
    public Boolean save(RegisterEntity entity) {

        System.out.println("invoking save registerImpl");

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

            isSaved = true;

            et.commit();

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

        System.out.println("invoking saveAll:RegisterDAOImpl");

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

        System.out.println(
                "invoking getRegisterEntityById:RegisterDAOImpl");

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


    @Override
    public List<RegisterEntity> readAllRegisterEntity() {

        System.out.println("invoking readAll:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery("getallregisterentity")
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookName(
            String bookName) {

        System.out.println(
                "invoking getRegisterByBookName:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery("getregisterbybookname")
                    .setParameter("bookName", bookName)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookAuthor(
            String bookAuthor) {

        System.out.println(
                "invoking getRegisterByBookAuthor:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery("getregisterbybookauthor")
                    .setParameter("bookAuthor", bookAuthor)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookId(
            Integer bookId) {

        System.out.println(
                "invoking getRegisterByBookId:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery("getregisterbybookid")
                    .setParameter("bookId", bookId)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookNameAndAuthor(
            String bookName, String bookAuthor) {

        System.out.println(
                "invoking getRegisterByBookNameAndAuthor:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery(
                            "getregisterbybooknameandauthor")
                    .setParameter("bookName", bookName)
                    .setParameter("bookAuthor", bookAuthor)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookIdGreaterThan(
            Integer bookId) {

        System.out.println(
                "invoking getRegisterByBookIdGreaterThan:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery(
                            "getregisterbybookidgreaterthan")
                    .setParameter("bookId", bookId)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookIdLessThan(
            Integer bookId) {

        System.out.println(
                "invoking getRegisterByBookIdLessThan:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery(
                            "getregisterbybookidlessthan")
                    .setParameter("bookId", bookId)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByAuthorAndBookId(
            String bookAuthor, Integer bookId) {

        System.out.println(
                "invoking getRegisterByAuthorAndBookId:RegisterDAOImpl");

        List<RegisterEntity> registerEntityList =
                Collections.emptyList();

        try {

            registerEntityList = Persistence
                    .createEntityManagerFactory("book")
                    .createEntityManager()
                    .createNamedQuery(
                            "getregisterbyauthorandbookid")
                    .setParameter("bookAuthor", bookAuthor)
                    .setParameter("bookId", bookId)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + registerEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return registerEntityList;
    }
}
