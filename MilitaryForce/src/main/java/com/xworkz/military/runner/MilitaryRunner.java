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


        List<MilitaryDTO> getByName = service.getMilitaryByName("Arjun");
        System.out.println(getByName);


        List<MilitaryDTO> getByRank = service.getMilitaryByRank("Captain");
        System.out.println(getByRank);


        List<MilitaryDTO> getByAge = service.getMilitaryByAge(30);
        System.out.println(getByAge);


        List<MilitaryDTO> getByNameAndRank = service.getMilitaryByNameAndRank("Arjun", "Captain");
        System.out.println(getByNameAndRank);


        List<MilitaryDTO> getByAgeGreaterThan = service.getMilitaryByAgeGreaterThan(28);
        System.out.println(getByAgeGreaterThan);


        List<MilitaryDTO> getByAgeLessThan = service.getMilitaryByAgeLessThan(35);
        System.out.println(getByAgeLessThan);


        List<MilitaryDTO> getByRankAndAge = service.getMilitaryByRankAndAge("Captain", 30);
        System.out.println(getByRankAndAge);
    }
}

