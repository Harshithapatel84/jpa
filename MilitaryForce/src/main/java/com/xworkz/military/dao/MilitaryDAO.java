package com.xworkz.military.dao;

import com.xworkz.military.entity.MilitaryEntity;

import java.util.List;

public interface MilitaryDAO {

    String saveAll(List<MilitaryEntity> militaryEntityList);

    MilitaryEntity getById(Integer id);
}