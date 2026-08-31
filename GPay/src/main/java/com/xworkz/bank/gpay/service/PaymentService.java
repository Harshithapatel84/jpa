 package com.xworkz.bank.gpay.service;

import com.xworkz.bank.gpay.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    boolean save(PaymentDTO paymentDTO);

    Boolean saveAll(List<PaymentDTO> paymentDTOList);

    PaymentDTO getById(Integer id);

    List<PaymentDTO> readAllPaymentDto();

    List<PaymentDTO> getPaymentById(int id);




}

