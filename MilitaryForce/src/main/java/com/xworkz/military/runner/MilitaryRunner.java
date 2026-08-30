package com.xworkz.military.runner;

import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.service.MilitaryService;
import com.xworkz.military.service.impl.MilitaryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MilitaryRunner {

    public static void main(String[] args) {

        MilitaryService militaryService = new MilitaryServiceImpl();

        List<MilitaryDTO> militaryDTOList = new ArrayList<>();

        militaryDTOList.add(new MilitaryDTO("Arjun", "Captain", 32));
        militaryDTOList.add(new MilitaryDTO("Rahul", "Major", 35));
        militaryDTOList.add(new MilitaryDTO("Priya", "Lieutenant", 28));

        String saved = militaryService.saveAll(militaryDTOList);

        System.out.println(saved);
    }
}