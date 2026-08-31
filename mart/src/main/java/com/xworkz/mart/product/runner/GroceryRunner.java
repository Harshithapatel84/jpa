package com.xworkz.mart.product.runner;

import com.xworkz.mart.product.dto.GroceryDTO;
import com.xworkz.mart.product.service.GroceryService;
import com.xworkz.mart.product.service.impl.GroceryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GroceryRunner {

    public static void main(String[] args) {

        GroceryDTO groceryDTO = new GroceryDTO("Rice", 50.0, "India Gate");

        GroceryService service = new GroceryServiceImpl();

        //String isSaved = service.save(groceryDTO);
        //System.out.println(isSaved);


        List<GroceryDTO> groceryDTOS =
                new ArrayList<GroceryDTO>();

        groceryDTOS.add(new GroceryDTO("Rice", 60.0, "India Gate"));

        groceryDTOS.add(new GroceryDTO("Oil", 150.0, "Fortune"));

        groceryDTOS.add(new GroceryDTO("Sugar", 45.0, "Madhur"));

        //String saved = service.saveAll(groceryDTOS);
        //System.out.println(saved);


        GroceryDTO getByName = service.findByname("Rice");

        System.out.println(getByName);


        List<GroceryDTO> readAll = service.readAllGroceryDto();
        System.out.println(readAll);


        List<GroceryDTO> getByGroceryName = service.getGroceryByNameDto("Rice");

        System.out.println(getByGroceryName);



    }
}

