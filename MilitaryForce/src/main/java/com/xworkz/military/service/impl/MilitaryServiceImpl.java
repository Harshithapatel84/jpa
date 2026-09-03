 package com.xworkz.military.service.impl;

import com.xworkz.military.dao.MilitaryDAO;
import com.xworkz.military.dao.impl.MilitaryDaoImpl;
import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.entity.MilitaryEntity;
import com.xworkz.military.service.MilitaryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MilitaryServiceImpl implements MilitaryService {

    MilitaryDAO dao = new MilitaryDaoImpl();


    @Override
    public String saveAll(List<MilitaryDTO> list) {

        System.out.println("invoking saveAll:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities = list.stream()
                .map(militaryDTO -> new MilitaryEntity(
                        null,
                        militaryDTO.getName(),
                        militaryDTO.getRank(),
                        militaryDTO.getAge()
                ))
                .collect(Collectors.toList());

        String status = dao.saveAll(militaryEntities);

        return status;
    }


    @Override
    public MilitaryDTO getById(Integer id) {

        System.out.println("invoking getById:MilitaryServiceImpl");

        MilitaryEntity entity = dao.getById(id);

        if (entity != null) {

            MilitaryDTO dto = new MilitaryDTO();

            dto.setName(entity.getName());
            dto.setRank(entity.getRank());
            dto.setAge(entity.getAge());

            return dto;
        }

        return null;
    }


    @Override
    public List<MilitaryDTO> readAllMilitaryDto() {

        System.out.println(
                "invoking readAll:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.readAllMilitaryEntity();

        List<MilitaryDTO> militaryDTOs =
                new ArrayList<>();

        for (MilitaryEntity entity : militaryEntities) {

            MilitaryDTO dto = new MilitaryDTO();

            dto.setName(entity.getName());
            dto.setRank(entity.getRank());
            dto.setAge(entity.getAge());

            militaryDTOs.add(dto);
        }

        return militaryDTOs;
    }

    @Override
        public String updateRankByName(String rank, String name) {


            System.out.println("invoking update rank by name");

            String status = null;

            if (rank != null && name != null) {

                Boolean isUpdated = dao.updateRankByName(rank, name);

                if (isUpdated) {
                    status = "data updated";
                } else {
                    status = "data not updated";
                }
            }

            return status;


        }
    @Override
    public String updateAgeByName(int age, String name) {

        System.out.println("invoking update age by name");

        String status = null;

        if (age != 0 && name != null) {

            Boolean isUpdated = dao.updateAgeByName(age, name);

            if (isUpdated) {
                status = "data updated";
            } else {
                status = "data not updated";
            }
        }

        return status;

    }

    @Override
    public String updateRankByNameAndAge(String rank, String name, int age) {

        System.out.println("invoking update rank by name and age");

        String status = null;

        if (rank != null && name != null && age != 0) {

            Boolean isUpdated = dao.updateRankByNameAndAge(rank, name, age);

            if (isUpdated) {
                status = "data updated";
            } else {
                status = "data not updated";
            }
        }

        return status;


    }


}




