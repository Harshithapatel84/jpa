 package com.xworkz.bank.gpay.dao;

import com.xworkz.bank.gpay.entity.PaymentEntity;

import java.util.List;

public interface PaymentDAO {

    boolean save(PaymentEntity paymentEntity);

    Boolean saveAll(List<PaymentEntity> paymentEntityList);

    PaymentEntity getById(Integer id);

    List<PaymentEntity> readAllPaymentEntity();

    List<PaymentEntity> getPaymentById(int id);

    boolean updateByName(String senderName);

    boolean updateSenderNameById(Integer id, String senderName);

    boolean updateAmountById(Integer id, Double amount);

    boolean deletePaymentById(Integer id);

    boolean deletePaymentBySenderName(String senderName);
}

