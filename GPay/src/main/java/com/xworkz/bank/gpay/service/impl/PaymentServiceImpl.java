 package com.xworkz.bank.gpay.service.impl;

import com.xworkz.bank.gpay.dao.PaymentDAO;
import com.xworkz.bank.gpay.dao.impl.PaymentDaoImpl;
import com.xworkz.bank.gpay.dto.PaymentDTO;
import com.xworkz.bank.gpay.entity.PaymentEntity;
import com.xworkz.bank.gpay.service.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements PaymentService {

    PaymentDAO dao = new PaymentDaoImpl();


    @Override
    public boolean save(PaymentDTO paymentDTO) {

        System.out.println("invoking save : PaymentServiceImpl");

        if (paymentDTO != null) {

            PaymentEntity entity = new PaymentEntity(
                    null,
                    paymentDTO.getSenderName(),
                    paymentDTO.getAmount()
            );

            return dao.save(entity);
        }

        return false;
    }


    @Override
    public Boolean saveAll(List<PaymentDTO> paymentDTOList) {

        System.out.println("invoking saveAll : PaymentServiceImpl");

        Boolean isSaved = false;

        if (paymentDTOList != null) {

            List<PaymentEntity> paymentEntityList = paymentDTOList.stream()
                    .map(paymentDTO -> new PaymentEntity(
                            null,
                            paymentDTO.getSenderName(),
                            paymentDTO.getAmount()))
                    .collect(Collectors.toList());

            isSaved = dao.saveAll(paymentEntityList);
        }

        return isSaved;
    }


    @Override
    public PaymentDTO getById(Integer id) {

        System.out.println("invoking getById : PaymentServiceImpl");

        PaymentEntity entity = dao.getById(id);

        if (entity != null) {

            return new PaymentDTO(
                    entity.getId(),
                    entity.getSenderName(),
                    entity.getAmount()
            );
        }

        return null;
    }


    @Override
    public List<PaymentDTO> readAllPaymentDto() {

        System.out.println("invoking readAllPaymentDto : PaymentServiceImpl");

        List<PaymentEntity> paymentEntities =
                dao.readAllPaymentEntity();

        List<PaymentDTO> paymentDTOs = new ArrayList<>();

        for (PaymentEntity entity : paymentEntities) {

            PaymentDTO dto = new PaymentDTO(
                    entity.getId(),
                    entity.getSenderName(),
                    entity.getAmount()
            );

            paymentDTOs.add(dto);
        }

        return paymentDTOs;
    }


    @Override
    public List<PaymentDTO> getPaymentById(int id) {

        System.out.println("invoking getPaymentById : PaymentServiceImpl");

        return dao.getPaymentById(id)
                .stream()
                .map(entity -> new PaymentDTO(
                        entity.getId(),
                        entity.getSenderName(),
                        entity.getAmount()))
                .collect(Collectors.toList());
    }


}

