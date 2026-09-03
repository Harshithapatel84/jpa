 package com.xworkz.bank.gpay.service;

import com.xworkz.bank.gpay.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    boolean save(PaymentDTO paymentDTO);

    Boolean saveAll(List<PaymentDTO> paymentDTOList);

    PaymentDTO getById(Integer id);

    List<PaymentDTO> readAllPaymentDto();


    PaymentDTO getPaymentBySenderName(String senderName);

    PaymentDTO getPaymentByAmount(Double amount);

    List<PaymentDTO> getPaymentBySenderNameAndAmount(String senderName, Double amount);

    List<PaymentDTO> getPaymentBySenderNameOrAmount(String senderName, Double amount);

    List<PaymentDTO> getPaymentByAmountGreaterThan(Double amount);

    String updateSenderNameById(String senderName, int id);

    String updateAmountById(Double amount, int id);

}

