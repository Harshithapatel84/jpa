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

    boolean updateRankByName(String rank, String name);

    boolean updateAgeByName(Integer age, String name);

    boolean updateRankByNameAndAge(String rank, String name, Integer age);

    boolean deleteMilitaryByName(String name);

    boolean deleteMilitaryByRankOrAge(String rank, Integer age);


}
