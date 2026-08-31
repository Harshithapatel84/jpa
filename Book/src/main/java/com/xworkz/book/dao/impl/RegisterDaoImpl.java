package com.xworkz.book.dao.impl;

import com.xworkz.book.dao.RegisterDAO;
import com.xworkz.book.entity.RegisterEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class RegisterDaoImpl implements RegisterDAO {


    @Override
    public Boolean save(RegisterEntity entity) {

        System.out.println("invoking save:RegisterDaoImpl");

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

        System.out.println("invoking saveAll:RegisterDaoImpl");

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

        System.out.println("invoking getRegisterEntityById:RegisterDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            return em.find(RegisterEntity.class, bookId);

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

        System.out.println("invoking readAll:RegisterDaoImpl");

        List<RegisterEntity> registerEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            registerEntityList = em
                    .createNamedQuery("getallregisterentity", RegisterEntity.class)
                    .getResultList();

            System.out.println("listOfEntity:" + registerEntityList);

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

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookName(String bookName) {

        System.out.println("invoking getRegisterByBookName:RegisterDaoImpl");

        List<RegisterEntity> registerEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            registerEntityList = em
                    .createNamedQuery("getregisterbybookname", RegisterEntity.class)
                    .setParameter("bookName", bookName)
                    .getResultList();

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

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookAuthor(String bookAuthor) {

        System.out.println("invoking getRegisterByBookAuthor:RegisterDaoImpl");

        List<RegisterEntity> registerEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            registerEntityList = em
                    .createNamedQuery("getregisterbybookauthor", RegisterEntity.class)
                    .setParameter("bookAuthor", bookAuthor)
                    .getResultList();

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

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByBookNameAndAuthor(String bookName, String bookAuthor) {

        System.out.println("invoking getRegisterByBookNameAndAuthor:RegisterDaoImpl");

        List<RegisterEntity> registerEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            registerEntityList = em
                    .createNamedQuery("getregisterbybooknameandauthor", RegisterEntity.class)
                    .setParameter("bookName", bookName)
                    .setParameter("bookAuthor", bookAuthor)
                    .getResultList();

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

        return registerEntityList;
    }


    @Override
    public List<RegisterEntity> getRegisterByAuthorOrBookId(String bookAuthor, Integer bookId) {

        System.out.println("invoking getRegisterByAuthorOrBookId:RegisterDaoImpl");

        List<RegisterEntity> registerEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();

            registerEntityList = em
                    .createNamedQuery("getregisterbyauthororbookid", RegisterEntity.class)
                    .setParameter("bookAuthor", bookAuthor)
                    .setParameter("bookId", bookId)
                    .getResultList();

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

        return registerEntityList;
    }


    @Override
    public boolean updateBookNameById(String bookName, Integer bookId) {

        System.out.println("invoking updateBookNameById:RegisterDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            int result = em
                    .createNamedQuery("updatebooknamebyid")
                    .setParameter("bookName", bookName)
                    .setParameter("bookId", bookId)
                    .executeUpdate();

            et.commit();

            return result > 0;

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
    public boolean updateBookAuthorById(String bookAuthor, Integer bookId) {

        System.out.println("invoking updateBookAuthorById:RegisterDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            int result = em
                    .createNamedQuery("updatebookauthorbyid")
                    .setParameter("bookAuthor", bookAuthor)
                    .setParameter("bookId", bookId)
                    .executeUpdate();

            et.commit();

            return result > 0;

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
    public boolean updateBookAuthorByNameAndBookId(String bookAuthor, String bookName, Integer bookId) {

        System.out.println("invoking updateBookAuthorByNameAndBookId:RegisterDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            int result = em
                    .createNamedQuery("updatebookauthorbynameandbookid")
                    .setParameter("bookAuthor", bookAuthor)
                    .setParameter("bookName", bookName)
                    .setParameter("bookId", bookId)
                    .executeUpdate();

            et.commit();

            return result > 0;

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
    public boolean deleteRegisterByBookId(Integer bookId) {

        System.out.println("invoking deleteRegisterByBookId:RegisterDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            int result = em
                    .createNamedQuery("deleteregisterbybookid")
                    .setParameter("bookId", bookId)
                    .executeUpdate();

            et.commit();

            return result > 0;

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
    public boolean deleteRegisterByAuthorOrBookName(String bookAuthor, String bookName) {

        System.out.println("invoking deleteRegisterByAuthorOrBookName:RegisterDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("book");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            int result = em
                    .createNamedQuery("deleteregisterbyauthororbookname")
                    .setParameter("bookAuthor", bookAuthor)
                    .setParameter("bookName", bookName)
                    .executeUpdate();

            et.commit();

            return result > 0;

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

}
