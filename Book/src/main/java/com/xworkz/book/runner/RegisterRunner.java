package com.xworkz.book.runner;

import com.xworkz.book.dto.RegisterDTO;
import com.xworkz.book.service.RegisterService;
import com.xworkz.book.service.impl.RegisterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RegisterRunner {


    public static void main(String[] args) {

        RegisterService service = new RegisterServiceImpl();

        RegisterDTO registerDTO = new RegisterDTO(4, "Java", "James Gosling");

        // String isSaved = service.save(registerDTO);
        // System.out.println(isSaved);

        List<RegisterDTO> registerDTOS = new ArrayList<>();

        registerDTOS.add(new RegisterDTO(8, "Java", "James Gosling"));
        registerDTOS.add(new RegisterDTO(7, "Python", "Guido van Rossum"));
        registerDTOS.add(new RegisterDTO(6, "C++", "Bjarne Stroustrup"));

        // String saved = service.saveAll(registerDTOS);
        // System.out.println(saved);

        RegisterDTO getById = service.getById(1);
        System.out.println(getById);

        List<RegisterDTO> readAll = service.readAllRegisterDto();
        System.out.println(readAll);

        List<RegisterDTO> getByBookName = service.getRegisterByBookName("Java");
        System.out.println(getByBookName);

    }
}
