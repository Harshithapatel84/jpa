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

       // Boolean isSaved = service.save(groceryDTO);
        //System.out.println(isSaved);


        List<GroceryDTO> groceryDTOS =
                new ArrayList<GroceryDTO>();

        groceryDTOS.add(new GroceryDTO("Rice", 60.0, "India Gate"));

        groceryDTOS.add(new GroceryDTO("Oil", 150.0, "Fortune"));

        groceryDTOS.add(new GroceryDTO("Sugar", 45.0, "Madhur"));

        groceryDTOS.add(new GroceryDTO("soap" ,60.0,"mysore sandal"));

        groceryDTOS.add(new GroceryDTO("wheat flour",70.0,"ashirwad"));

        groceryDTOS.add(new GroceryDTO("rava",45.0,"sooji"));

       // String saved = service.saveAll(groceryDTOS);
        //System.out.println(saved);

        List<GroceryDTO> readAll = service.readAllGroceryDto();
        System.out.println(readAll);

        GroceryDTO getByBrand=service.getByBrand("ashirwad");
        System.out.println(getByBrand);

        GroceryDTO getByName=service.getByName("rava");
        System.out.println(getByName);

        List<GroceryDTO> dto=service.getByBrandAndName("soap","mysore sandal");
        System.out.println(dto);

        List<GroceryDTO> result = service.getByBrandorPrice("Fortune", 150.0);
        System.out.println(result);




    }
}

