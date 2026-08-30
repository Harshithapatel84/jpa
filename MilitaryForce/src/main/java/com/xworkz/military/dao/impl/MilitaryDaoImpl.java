package com.xworkz.military.dao.impl;

import com.xworkz.military.dao.MilitaryDAO;
import com.xworkz.military.entity.MilitaryEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class MilitaryDaoImpl implements MilitaryDAO {

    @Override
    public String saveAll(List<MilitaryEntity> militaryEntityList) {

        System.out.println("invoking saveAll:MilitaryDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        String isSaved = null;

        try {

            emf = Persistence.createEntityManagerFactory("military");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (MilitaryEntity entity : militaryEntityList) {
                em.persist(entity);
            }

            et.commit();

            isSaved = "data saved";

        } catch (PersistenceException e) {

            e.printStackTrace();

            if (et != null && et.isActive()) {
                et.rollback();
            }

            isSaved = "data not saved";

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
    public MilitaryEntity getById(Integer id) {

        System.out.println("invoking getById:MilitaryDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("military");
            em = emf.createEntityManager();

            MilitaryEntity entity =
                    em.find(MilitaryEntity.class, id);

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
    public List<MilitaryEntity> readAllMilitaryEntity() {

        System.out.println("invoking readAll:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getallmilitaryentity")
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByName(String name) {

        System.out.println(
                "invoking getMilitaryByName:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybyname")
                    .setParameter("name", name)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByRank(String rank) {

        System.out.println(
                "invoking getMilitaryByRank:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybyrank")
                    .setParameter("rank", rank)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByAge(Integer age) {

        System.out.println(
                "invoking getMilitaryByAge:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybyage")
                    .setParameter("age", age)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByNameAndRank(
            String name, String rank) {

        System.out.println(
                "invoking getMilitaryByNameAndRank:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybynameandrank")
                    .setParameter("name", name)
                    .setParameter("rank", rank)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByAgeGreaterThan(
            Integer age) {

        System.out.println(
                "invoking getMilitaryByAgeGreaterThan:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybyagegreaterthan")
                    .setParameter("age", age)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByAgeLessThan(
            Integer age) {

        System.out.println(
                "invoking getMilitaryByAgeLessThan:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybyagelessthan")
                    .setParameter("age", age)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }


    @Override
    public List<MilitaryEntity> getMilitaryByRankAndAge(
            String rank, Integer age) {

        System.out.println(
                "invoking getMilitaryByRankAndAge:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList =
                Collections.emptyList();

        try {

            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getmilitarybyrankandage")
                    .setParameter("rank", rank)
                    .setParameter("age", age)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }
}

