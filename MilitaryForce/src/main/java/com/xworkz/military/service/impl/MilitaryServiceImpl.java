package com.xworkz.military.service.impl;

import com.xworkz.military.dao.MilitaryDAO;
import com.xworkz.military.dao.impl.MilitaryDaoImpl;
import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.entity.MilitaryEntity;
import com.xworkz.military.service.MilitaryService;

import java.util.List;
import java.util.stream.Collectors;

public class MilitaryServiceImpl implements MilitaryService {

    MilitaryDAO dao = new MilitaryDaoImpl();

    @Override
    public String saveAll(List<MilitaryDTO> militaryDTOList) {

        System.out.println("invoking saveAll");

        String isSaved = null;

        if (militaryDTOList != null) {

            List<MilitaryEntity> militaryEntityList =
                    militaryDTOList.stream()
                            .map(militaryDTO ->
                                    new MilitaryEntity(
                                            null,
                                            militaryDTO.getName(),
                                            militaryDTO.getRank(),
                                            militaryDTO.getAge()
                                    ))
                            .collect(Collectors.toList());

            String status = dao.saveAll(militaryEntityList);

            if ("data saved".equals(status)) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }
        }

        return isSaved;
    }

    @Override
    public MilitaryEntity getById(Integer id) {

        System.out.println("invoking getById");

        if (id != null) {
            return dao.getById(id);
        }

        return null;
    }
}