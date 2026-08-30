 package com.xworkz.military.dao;

import com.xworkz.military.entity.MilitaryEntity;

import java.util.List;

public interface MilitaryDAO {

    String saveAll(List<MilitaryEntity> militaryEntityList);

    MilitaryEntity getById(Integer id);

    List<MilitaryEntity> readAllMilitaryEntity();

    List<MilitaryEntity> getMilitaryByName(String name);

    List<MilitaryEntity> getMilitaryByRank(String rank);

    List<MilitaryEntity> getMilitaryByAge(Integer age);

    List<MilitaryEntity> getMilitaryByNameAndRank(String name, String rank);

    List<MilitaryEntity> getMilitaryByAgeGreaterThan(Integer age);

    List<MilitaryEntity> getMilitaryByAgeLessThan(Integer age);

    List<MilitaryEntity> getMilitaryByRankAndAge(String rank, Integer age);

}

