package com.xworkz.bank.gpay.service.impl;

import com.xworkz.bank.gpay.dao.PaymentDAO;
import com.xworkz.bank.gpay.dao.impl.PaymentDaoImpl;
import com.xworkz.bank.gpay.dto.PaymentDTO;
import com.xworkz.bank.gpay.entity.PaymentEntity;
import com.xworkz.bank.gpay.service.PaymentService;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements PaymentService {

    PaymentDAO dao=new PaymentDaoImpl();
    @Override
    public String saveAll(List<PaymentDTO> paymentDTOList) {

        System.out.println("invoking saveAll");

        String isSaved = null;

        if (paymentDTOList != null) {

            List<PaymentEntity> paymentEntityList = paymentDTOList.stream()
                    .map(paymentDTO -> new PaymentEntity(null, paymentDTO.getSenderName(),
                            paymentDTO.getAmount()))
                    .collect(Collectors.toList());

            String status = dao.saveAll(paymentEntityList);

            if (status != null) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }
        }

        return isSaved;
    }
}

