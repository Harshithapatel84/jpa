package com.xworkz.military.service;

import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.entity.MilitaryEntity;

import java.util.List;

public interface MilitaryService {

    String saveAll(List<MilitaryDTO> militaryDTOList);

    MilitaryEntity getById(Integer id);
}