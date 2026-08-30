package com.xworkz.bank.gpay.dao.impl;

import com.xworkz.bank.gpay.dao.PaymentDAO;
import com.xworkz.bank.gpay.entity.PaymentEntity;

import javax.persistence.*;
import java.util.List;

public class PaymentDaoImpl implements PaymentDAO
{


    @Override
    public String saveAll(List<PaymentEntity> paymentEntityList) {

        System.out.println("invoking saveall: groceryDaoImpl");
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

       String isSaved=null;

       try{
           emf= Persistence.createEntityManagerFactory("gpay");
           em=emf.createEntityManager();
           et=em.getTransaction();
           et.begin();

           for(PaymentEntity entity:paymentEntityList){
               em.persist(entity);
           }
           et.commit();
         isSaved="success";
       }catch (PersistenceException e)
       {
           e.printStackTrace();
           if(et!=null && et.isActive())
           {
               et.rollback();
           }
           isSaved="fail";
       }
       finally {
           if (emf!=null){
               emf.close();
           }
           if (em!=null){
               em.close();
           }
       }
       return isSaved;
    }
}
