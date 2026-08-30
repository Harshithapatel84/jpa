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
    public List<MilitaryDTO> getMilitaryByName(String name) {

        System.out.println(
                "invoking getMilitaryByName:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByName(name);

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
    public List<MilitaryDTO> getMilitaryByRank(String rank) {

        System.out.println(
                "invoking getMilitaryByRank:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByRank(rank);

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
    public List<MilitaryDTO> getMilitaryByAge(Integer age) {

        System.out.println(
                "invoking getMilitaryByAge:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByAge(age);

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
    public List<MilitaryDTO> getMilitaryByNameAndRank(
            String name, String rank) {

        System.out.println(
                "invoking getMilitaryByNameAndRank:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByNameAndRank(name, rank);

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
    public List<MilitaryDTO> getMilitaryByAgeGreaterThan(
            Integer age) {

        System.out.println(
                "invoking getMilitaryByAgeGreaterThan:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByAgeGreaterThan(age);

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
    public List<MilitaryDTO> getMilitaryByAgeLessThan(
            Integer age) {

        System.out.println(
                "invoking getMilitaryByAgeLessThan:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByAgeLessThan(age);

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
    public List<MilitaryDTO> getMilitaryByRankAndAge(
            String rank, Integer age) {

        System.out.println(
                "invoking getMilitaryByRankAndAge:MilitaryServiceImpl");

        List<MilitaryEntity> militaryEntities =
                dao.getMilitaryByRankAndAge(rank, age);

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
}

