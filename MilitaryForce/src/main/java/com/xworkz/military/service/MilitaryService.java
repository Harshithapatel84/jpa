
        package com.xworkz.military.service;

import com.xworkz.military.dto.MilitaryDTO;

import java.util.List;

public interface MilitaryService {

    String saveAll(List<MilitaryDTO> list);

    MilitaryDTO getById(Integer id);

    List<MilitaryDTO> readAllMilitaryDto();

    List<MilitaryDTO> getMilitaryByName(String name);

    List<MilitaryDTO> getMilitaryByRank(String rank);

    List<MilitaryDTO> getMilitaryByAge(Integer age);

    List<MilitaryDTO> getMilitaryByNameAndRank(
            String name, String rank);

    List<MilitaryDTO> getMilitaryByAgeGreaterThan(
            Integer age);

    List<MilitaryDTO> getMilitaryByAgeLessThan(
            Integer age);

    List<MilitaryDTO> getMilitaryByRankAndAge(
            String rank, Integer age);

}

