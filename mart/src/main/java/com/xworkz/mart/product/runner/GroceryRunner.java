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


        List<GroceryDTO> getByBrand = service.getGroceryByBrand("Fortune");
        System.out.println(getByBrand);


        List<GroceryDTO> getByPrice = service.getGroceryByPrice(60.0);
        System.out.println(getByPrice);


        List<GroceryDTO> getByNameAndBrand = service.getGroceryByNameAndBrand("Rice", "India Gate");
        System.out.println(getByNameAndBrand);


        List<GroceryDTO> getByPriceGreaterThan = service.getGroceryByPriceGreaterThan(50.0);
        System.out.println(getByPriceGreaterThan);


        List<GroceryDTO> getByPriceLessThan = service.getGroceryByPriceLessThan(100.0);
        System.out.println(getByPriceLessThan);


        List<GroceryDTO> getByBrandAndPrice = service.getGroceryByBrandAndPrice("India Gate", 60.0);
        System.out.println(getByBrandAndPrice);

    }
}

