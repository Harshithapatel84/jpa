package com.xworkz.military.dao.impl;

import com.xworkz.military.dao.MilitaryDAO;
import com.xworkz.military.entity.MilitaryEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class MilitaryDaoImpl implements MilitaryDAO {

    public  static  final EntityManagerFactory emf=Persistence.createEntityManagerFactory("military");
    @Override
    public String saveAll(List<MilitaryEntity> militaryEntityList) {

        System.out.println("invoking saveAll:MilitaryDAOImpl");


        EntityManager em = null;
        EntityTransaction et = null;

        String isSaved = null;

        try {

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


        }

        return isSaved;
    }


    @Override
    public MilitaryEntity getById(Integer id) {

        System.out.println("invoking getById:MilitaryDAOImpl");
        EntityManager em = null;

        try {
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

        }
    }


    @Override
    public List<MilitaryEntity> readAllMilitaryEntity() {

        System.out.println("invoking readAll:MilitaryDAOImpl");

        List<MilitaryEntity> militaryEntityList = Collections.emptyList();

        try {
            militaryEntityList = Persistence
                    .createEntityManagerFactory("military")
                    .createEntityManager()
                    .createNamedQuery("getAllMilitaryEntity")
                    .getResultList();

            System.out.println("listOfEntity:" + militaryEntityList);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

        }

        return militaryEntityList;
    }

    @Override
    public boolean updateRankByName(String rank, String name) {
        System.out.println("performing update by rank using name");
        EntityManager em=null;
        EntityTransaction et=null;
        boolean update=false;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            Query query=em.createQuery( "update MilitaryEntity r set r.rank = :rank where r.name = :name");
query.setParameter("rank",rank);
query.setParameter("name",name);
int rowUpdated=query.executeUpdate();
if(rowUpdated>0){
    update=true;
}et.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return update;
    }

    @Override
    public boolean updateAgeByName(int age, String name) {

        System.out.println("performing update age using name");

        EntityManager em = null;
        EntityTransaction et = null;
        boolean update = false;

        try {

            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            Query query = em.createNamedQuery("updateAgeByName");

            query.setParameter("age", age);
            query.setParameter("name", name);

            int rowUpdated = query.executeUpdate();

            if (rowUpdated > 0) {
                update = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return update;


    }

    @Override
    public boolean updateRankByNameAndAge(String rank, String name, int age) {


        System.out.println("performing update rank using name and age");

        EntityManager em = null;
        EntityTransaction et = null;
        boolean update = false;

        try {

            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            Query query = em.createNamedQuery("updateRankByNameAndAge");

            query.setParameter("rank", rank);
            query.setParameter("name", name);
            query.setParameter("age", age);

            int rowUpdated = query.executeUpdate();

            if (rowUpdated > 0) {
                update = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return update;

    }



}

