package com.xworkz.military.dao;

import com.xworkz.military.entity.MilitaryEntity;

import java.util.List;

public interface MilitaryDAO {

    String saveAll(List<MilitaryEntity> militaryEntityList);

    MilitaryEntity getById(Integer id);

    List<MilitaryEntity> readAllMilitaryEntity();

    //List<MilitaryEntity> getMilitaryByName(String name);



    boolean updateRankByName(String rank, String name);

    boolean updateAgeByName(int age, String name);

    boolean updateRankByNameAndAge(String rank, String name, int age);

}
