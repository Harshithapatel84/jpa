
        package com.xworkz.military.service;

import com.xworkz.military.dto.MilitaryDTO;

import java.util.List;

public interface MilitaryService {

    String saveAll(List<MilitaryDTO> list);

    MilitaryDTO getById(Integer id);

    List<MilitaryDTO> readAllMilitaryDto();

    String updateRankByName(String rank, String name);

    String updateAgeByName(int age, String name);

    String updateRankByNameAndAge(String rank, String name, int age);
}

