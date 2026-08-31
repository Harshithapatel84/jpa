package com.xworkz.cloud.device.dao.impl;

import com.xworkz.cloud.device.dao.SignupDAO;
import com.xworkz.cloud.device.entity.SignupEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class SignupDAOImpl implements SignupDAO {
    @Override
    public Boolean save(SignupEntity entity) {
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
            if (em != null) {
                em.close();
            }
        }
        return isSaved;
    }

    @Override
    public Boolean saveAll(List<SignupEntity> list) {

        System.out.println("invoking saveAll: SignUpDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        Boolean isSaved = false;

        try {
            emf = Persistence.createEntityManagerFactory("cloud");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            for (SignupEntity entity : list) {
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
    public SignupEntity getById(Integer id) {
        return null;
    }


    public SignupEntity getByid(Integer id) {
        System.out.println("Invoking getSignupEntityById: SignupDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("cloud");
            em = emf.createEntityManager();
            SignupEntity entity = em.find(SignupEntity.class, id);
            return entity;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();}
            if (emf != null) {
                emf.close();
            }
        }
    }

    @Override
    public List<SignupEntity> readAllSignupEntity() {
        System.out.println("invoking readAll by:signupDaoImpl");
        List<SignupEntity> signupEntityList=Collections.emptyList();
        try{
     signupEntityList=Persistence.createEntityManagerFactory("cloud").createEntityManager().createNamedQuery("getAllSignupEntity") .getResultList();
            System.out.println("listOfEntity:"+signupEntityList);

        }catch(PersistenceException e){
e.printStackTrace();
        }finally {

        }
        return  signupEntityList;
    }

    @Override
    public List<SignupEntity> getSignupById(int id) {
        System.out.println("invoking getSignupById : SignupDaoImpl");

        List<SignupEntity> signupEntityList = Collections.emptyList();

        try {

            signupEntityList = Persistence
                    .createEntityManagerFactory("cloud")
                    .createEntityManager()
                    .createNamedQuery("getSignupById")
                    .setParameter("id", id)
                    .getResultList();

            System.out.println("listOfEntity:" + signupEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return signupEntityList;
    }

    @Override
    public List<SignupEntity> getSignupByPassword(String password) {
        return Collections.emptyList();
    }

    @Override
    public List<SignupEntity> getSignupByEmail(String email) {
        return Collections.emptyList();
    }

    @Override
    public List<SignupEntity> getSignupByPasswordAndEmail(String password, String email) {
        return Collections.emptyList();
    }

    @Override
    public boolean updatePasswordById(int id, String password) {
        return false;
    }

    @Override
    public boolean updateEmailById(int id, String email) {
        return false;
    }

    @Override
    public boolean updateConfirmPasswordById(int id, String confirmPassword) {
        return false;
    }

    @Override
    public boolean deleteSignupById(int id) {
        return false;
    }

    @Override
    public boolean deleteSignupByEmail(String email) {
        return false;
    }


}


