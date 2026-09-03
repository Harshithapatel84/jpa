package com.xworkz.mart.product.dao.impl;

import com.xworkz.mart.product.dao.GroceryDAO;
import com.xworkz.mart.product.entity.GroceryEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GroceryDaoImpl implements GroceryDAO {
 public static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("mart");
    @Override
    public Boolean save(GroceryEntity entity) {

        System.out.println("invoking save groceryImpl");


        EntityManager em = null;
        EntityTransaction et = null;

        boolean isSaved = false;

        try {

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


        }

        return isSaved;
    }


    @Override
    public Boolean saveAll(List<GroceryEntity> groceryEntityList) {

        System.out.println("Invoking saveAll:GroceryDAOImpl");

        EntityManager em = null;
        EntityTransaction et = null;

        try {


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


        }
    }

    @Override
    public List<GroceryEntity> readAllGroceryEntity() {

        System.out.println("invoking readAll by:GroceryDaoImpl");

        List<GroceryEntity> groceryEntityList = Collections.emptyList();

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
    public GroceryEntity getByName(String name) {
        System.out.println("invoking grocery by name");
        GroceryEntity groceryEntity = null;

        EntityManager em=null;

        try{

            em=emf.createEntityManager();
            Query query=em.createNamedQuery("getgrocerybyname");
            query.setParameter("name",name);
            Object ref1=query.getSingleResult();
            groceryEntity=(GroceryEntity)ref1;


        }catch(PersistenceException e)
        {
            e.printStackTrace();
        }
        finally{
            if (em!=null){
                em.close();
            }
        }
        return groceryEntity;
    }


    @Override
    public GroceryEntity getGroceryByBrand(String brand) {

        System.out.println("invoking getGroceryByBrand : GroceryDaoImpl");

        GroceryEntity groceryEntity = null;
        EntityManager em = null;

        try {

            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getgrocerybybrand");
            query.setParameter("brand", brand);
            Object ref = query.getSingleResult();
            groceryEntity = (GroceryEntity) ref;
            System.out.println("listOfEntity:" + groceryEntity);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return groceryEntity;
    }



    @Override
    public List<GroceryEntity> getgrocerybynameandbrand(String name,String brand) {

        System.out.println("invoking getGroceryByBrandandName : GroceryDaoImpl");

        List<GroceryEntity> groceryEntity = null;

        EntityManager em = null;

        try {


            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getgrocerybynameandbrand");
            query.setParameter("brand",brand);
            query.setParameter("name",name);
            Object ref = query.getResultList();
            groceryEntity = (List<GroceryEntity>) ref;

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }


        return groceryEntity;
    }

    @Override
    public List<GroceryEntity> getgrocerybybrandorprice(String brand, Double price) {
        System.out.println("invoking getGroceryByBrandOrPrice");

        List<GroceryEntity> groceryEntity = null;


        EntityManager em = null;

        try {


            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getgrocerybybrandorprice");
            query.setParameter("brand", brand);
            query.setParameter("price", price);
            Object ref2 = query.getResultList();
            groceryEntity = (List<GroceryEntity>) ref2;

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

        }

        return groceryEntity;

    }

    @Override
    public Boolean updatepricebyname(Double price,String name) {
        System.out.println("update price using name");

        EntityManager em=null;
        EntityTransaction et=null;
        Boolean isUpdated=false;
        try{

            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            Query query=em.createQuery("update GroceryEntity r set r.price = :price where r.name = :name");
            query.setParameter("name",name);
            query.setParameter("price",price);
            int rowUpdated=query.executeUpdate();
            if(rowUpdated>0){
                isUpdated=true;
            }
            et.commit();
        }catch(PersistenceException e){
            e.printStackTrace();
            et.rollback();
        }finally{
            if(em!=null){
                em.close();
            }
        }

        return isUpdated;
    }
    @Override
    public Boolean updatepricebybrandandname(Double price, String brand, String name) {

        System.out.println("update price using brand and name");


        EntityManager em = null;
        EntityTransaction et = null;

        Boolean isUpdated = false;

        try {

            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("updatepricebybrandandname");
            query.setParameter("price", price);
            query.setParameter("brand", brand);
            query.setParameter("name", name);
            int rowUpdated = query.executeUpdate();
            if (rowUpdated > 0) {
                isUpdated = true;
            }
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {

            if (em != null) {
                em.close();
            }

        }
        return isUpdated;
    }
    @Override
    public Boolean updatebrandbyname(String brand, String name) {

        System.out.println("update brand using name");


        EntityManager em = null;
        EntityTransaction et = null;
        Boolean isUpdated = false;
        try {

            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            Query query = em.createNamedQuery("updatebrandbyname");
            query.setParameter("brand", brand);
            query.setParameter("name", name);
            int rowUpdated = query.executeUpdate();
            if (rowUpdated > 0) {
                isUpdated = true;
            }
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }

        }
        return isUpdated;
    }

    @Override
    public List<String> getNames() {
        System.out.println("get allThe names");
        List<String> stringList=Collections.emptyList();
        try{
            stringList =emf.createEntityManager()
                    .createQuery("select s.name from GroceryEntity s").getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return stringList;
    }


}