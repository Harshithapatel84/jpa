package com.xworkz.book.runner;

import com.xworkz.book.dto.RegisterDTO;
import com.xworkz.book.service.RegisterService;
import com.xworkz.book.service.impl.RegisterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RegisterRunner {

    public static void main(String[] args) {

        RegisterDTO dto = new RegisterDTO(null, "Java", "James Gosling");

        RegisterService service = new RegisterServiceImpl();

        boolean isSaved = service.save(dto);
        System.out.println("Book saved: " + isSaved);


        List<RegisterDTO> registerDTOList = new ArrayList<>();

        registerDTOList.add(new RegisterDTO(null, "Python", "Guido van Rossum"));

        registerDTOList.add(new RegisterDTO(null, "C Programming", "Dennis Ritchie"));

        registerDTOList.add(new RegisterDTO(null, "Clean Code", "Robert C. Martin"));


        String saved = service.saveAll(registerDTOList);
        System.out.println(saved);

        RegisterDTO dtoById = service.findById(1);
        System.out.println("Found Dto is: " + dtoById);
    }
}