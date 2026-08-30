package com.xworkz.military.dao.impl;

import com.xworkz.military.dao.MilitaryDAO;
import com.xworkz.military.entity.MilitaryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MilitaryDaoImpl implements MilitaryDAO {

    @Override
    public String saveAll(List<MilitaryEntity> militaryEntityList) {

        System.out.println("invoking saveAll DAO");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("military");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {

            et.begin();

            for (MilitaryEntity entity : militaryEntityList) {
                em.persist(entity);
            }

            et.commit();

            return "data saved";

        } catch (Exception e) {

            e.printStackTrace();

            if (et.isActive()) {
                et.rollback();
            }

            return "data not saved";

        } finally {

            em.close();
            emf.close();
        }
    }

    @Override
    public MilitaryEntity getById(Integer id) {

        System.out.println("invoking getById DAO");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("military");

        EntityManager em = emf.createEntityManager();

        try {

            MilitaryEntity entity =
                    em.find(MilitaryEntity.class, id);

            return entity;

        } finally {

            em.close();
            emf.close();
        }
    }
}