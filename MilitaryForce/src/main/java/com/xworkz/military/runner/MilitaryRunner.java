 package com.xworkz.military.runner;

import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.service.MilitaryService;
import com.xworkz.military.service.impl.MilitaryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MilitaryRunner {

    public static void main(String[] args) {

        MilitaryService service = new MilitaryServiceImpl();


        List<MilitaryDTO> militaryDTOs = new ArrayList<MilitaryDTO>();

        militaryDTOs.add(new MilitaryDTO("Arjun", "Captain", 30));
        militaryDTOs.add(new MilitaryDTO("Ravi", "Major", 35));
        militaryDTOs.add(new MilitaryDTO("Kiran", "Captain", 28));


        //String saved = service.saveAll(militaryDTOs);
        //System.out.println(saved);


        MilitaryDTO getById = service.getById(1);
        System.out.println(getById);


        List<MilitaryDTO> readAll = service.readAllMilitaryDto();
        System.out.println(readAll);


        String updated=service.updateRankByName("Major","Arjun");
        System.out.println(updated);

        String ageUpdated = service.updateAgeByName(32, "Arjun");
        System.out.println(ageUpdated);

        String rankUpdated = service.updateRankByNameAndAge("Colonel", "Arjun", 32);
        System.out.println(rankUpdated);
    }
}

