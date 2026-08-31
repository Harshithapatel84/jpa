package com.xworkz.mart.product.dao.impl;

import com.xworkz.mart.product.dao.GroceryDAO;
import com.xworkz.mart.product.entity.GroceryEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class GroceryDaoImpl implements GroceryDAO {

    @Override
    public Boolean save(GroceryEntity entity) {

        System.out.println("invoking save groceryImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        boolean isSaved = false;

        try {
            emf = Persistence.createEntityManagerFactory("mart");
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
    public Boolean saveAll(List<GroceryEntity> groceryEntityList) {

        System.out.println("Invoking saveAll:GroceryDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("mart");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (GroceryEntity entity : groceryEntityList) {
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
    public GroceryEntity getGroceryEntitybyName(String name) {

        System.out.println(
                "Invoking getGroceryEntityByName : GroceryDaoImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("mart");
            em = emf.createEntityManager();

            GroceryEntity entity =
                    em.find(GroceryEntity.class, name);

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
    public List<GroceryEntity> readAllGroceryEntity() {

        System.out.println("invoking readAll by:GroceryDaoImpl");

        List<GroceryEntity> groceryEntityList =
                Collections.emptyList();

        try {

            groceryEntityList = Persistence
                    .createEntityManagerFactory("mart")
                    .createEntityManager()
                    .createNamedQuery("getAllGroceryEntity")
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + groceryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return groceryEntityList;
    }


    @Override
    public List<GroceryEntity> getGroceryByName(String name) {

        System.out.println(
                "invoking getGroceryByName : GroceryDaoImpl");

        List<GroceryEntity> groceryEntityList =
                Collections.emptyList();

        try {

            groceryEntityList = Persistence
                    .createEntityManagerFactory("mart")
                    .createEntityManager()
                    .createNamedQuery("getGroceryByName")
                    .setParameter("name", name)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + groceryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return groceryEntityList;
    }


    @Override
    public List<GroceryEntity> getGroceryByBrand(String brand) {

        System.out.println(
                "invoking getGroceryByBrand : GroceryDaoImpl");

        List<GroceryEntity> groceryEntityList =
                Collections.emptyList();

        try {

            groceryEntityList = Persistence
                    .createEntityManagerFactory("mart")
                    .createEntityManager()
                    .createNamedQuery("getGroceryByBrand")
                    .setParameter("brand", brand)
                    .getResultList();

            System.out.println(
                    "listOfEntity:" + groceryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return groceryEntityList;
    }

    @Override
    public List<GroceryEntity> getGroceryByNameAndBrand(String name, String brand) {
        return Collections.emptyList();
    }

    @Override
    public List<GroceryEntity> getGroceryByBrandOrPrice(String brand, Double price) {
        return Collections.emptyList();
    }

    @Override
    public boolean updatePriceByName(Double price, String name) {
        return false;
    }

    @Override
    public boolean updateBrandByName(String brand, String name) {
        return false;
    }

    @Override
    public boolean updatePriceByBrandAndName(Double price, String brand, String name) {
        return false;
    }

    @Override
    public boolean deleteGroceryByName(String name) {
        return false;
    }

    @Override
    public boolean deleteGroceryByBrandOrPrice(String brand, Double price) {
        return false;
    }


}