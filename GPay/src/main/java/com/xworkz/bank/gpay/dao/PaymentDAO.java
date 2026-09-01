 package com.xworkz.bank.gpay.dao;

import com.xworkz.bank.gpay.entity.PaymentEntity;

import java.util.List;

public interface PaymentDAO {

    boolean save(PaymentEntity paymentEntity);

    Boolean saveAll(List<PaymentEntity> paymentEntityList);

    PaymentEntity getById(Integer id);

    List<PaymentEntity> readAllPaymentEntity();

    PaymentEntity getPaymentBySenderName(String senderName);

    PaymentEntity getPaymentByAmount(Double amount);

    List<PaymentEntity> getPaymentBySenderNameAndAmount(String senderName, Double amount);

    List<PaymentEntity> getPaymentBySenderNameOrAmount(String senderName, Double amount);

    List<PaymentEntity> getPaymentByAmountGreaterThan(Double amount);

  }

