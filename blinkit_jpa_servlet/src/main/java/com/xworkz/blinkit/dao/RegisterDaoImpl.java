package com.xworkz.blinkit.dao;

import com.xworkz.blinkit.entity.RegisterEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterDaoImpl implements RegisterDao{


    public  static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("register");
    @Override
    public boolean save(RegisterEntity entity) {
        System.out.println("invokins save:regiaterDaoImpl");
        boolean isSaved=false;
        EntityManager em=null;
        EntityTransaction et=null;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            em.persist(entity);
            isSaved=true;
            et.commit();

        }catch (PersistenceException e){
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
            isSaved = false;
        }
        finally {
            if(em!=null){
                em.close();
            }
        }

        return isSaved;
    }

    @Override
    public List<RegisterEntity> readAllRegister() {
        System.out.println("read all register");

        EntityManagerFactory emf=null;
        EntityManager em=null;

        List<RegisterEntity> registerEntityList=new ArrayList<>();
        try {
            emf = Persistence.createEntityManagerFactory("register");
            em = emf.createEntityManager();
          Query query= em.createQuery("select e from RegisterEntity e");
          registerEntityList=query.getResultList();

            return registerEntityList;
        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Boolean deleteRegisterById(Integer id) {
        System.out.println("invoking delete by id");
        Boolean isDelete=false;
        EntityManager em=null;
        EntityManagerFactory emf=null;
        EntityTransaction et=null;
        try{
            emf=Persistence.createEntityManagerFactory("register");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            RegisterEntity registerEntity=em.find(RegisterEntity.class,id);
            if (registerEntity!=null){
                em.remove(registerEntity);
                et.commit();
                isDelete=true;
            }

        }catch (PersistenceException e){
            e.printStackTrace();
            if (et != null ) {
                et.rollback();
            }
        }finally {
            if (emf!=null){
                emf.close();
            }
            if(em!=null){
                em.close();
            }
        }
        return isDelete;
    }
}
