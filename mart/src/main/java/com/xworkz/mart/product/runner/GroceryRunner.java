package com.xworkz.mart.product.runner;

import com.xworkz.mart.product.dao.GroceryDAO;
import com.xworkz.mart.product.dao.impl.GroceryDaoImpl;
import com.xworkz.mart.product.dto.GroceryDTO;
import com.xworkz.mart.product.service.GroceryService;
import com.xworkz.mart.product.service.impl.GroceryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GroceryRunner {

    public static void main(String[] args) {

        GroceryDTO groceryDTO = new GroceryDTO(null, 50.0, "Haldi Ram",null);

        System.out.println(groceryDTO);

        GroceryService service = new GroceryServiceImpl();

       Boolean isSaved = service.save(groceryDTO);
       System.out.println(isSaved);


//        List<GroceryDTO> groceryDTOS = new ArrayList<GroceryDTO>();
//
//       groceryDTOS.add(new GroceryDTO("Rice", 60.0, "India Gate",6.0));
//
//       groceryDTOS.add(new GroceryDTO("Oil", 150.0, "Fortune",6.0));
//
//        groceryDTOS.add(new GroceryDTO("Sugar", 45.0, "Madhur",6.0));
//
//        groceryDTOS.add(new GroceryDTO("soap" ,60.0,"mysore sandal",5.0));
//
//    groceryDTOS.add(new GroceryDTO("wheat flour",70.0,"ashirwad",3.0));
//
//      groceryDTOS.add(new GroceryDTO("rava",45.0,"sooji",4.0));
//
//        groceryDTOS.add(new GroceryDTO(null,0.0,"mayura",9.0));


//       String saved = service.saveAll(groceryDTOS);
//        System.out.println(saved);
//
//        List<GroceryDTO> readAll = service.readAllGroceryDto();
//        System.out.println(readAll);
//
//        GroceryDTO getByBrand=service.getByBrand("ashirwad");
//        System.out.println(getByBrand);
//
//        GroceryDTO getByName=service.getByName("rava");
//        System.out.println(getByName);
//
//        List<GroceryDTO> dto=service.getByBrandAndName("soap","mysore sandal");
//        System.out.println(dto);
//
//        List<GroceryDTO> result = service.getByBrandorPrice("Fortune", 150.0);
//        System.out.println(result);
//
//        String isUpdated=service.updatepricebyname(80.0,"sugar");
//        System.out.println(isUpdated);
//
//        String priceUpdated=service.updatepricebybrandandname(100.0,"ashirwad","wheat flour");
//        System.out.println(priceUpdated);
//
//        String brandUpdated=service.updatebrandbyname("Tata","rava");
//        System.out.println(brandUpdated);
//
//        GroceryDAO groceryDAO = new GroceryDaoImpl();

//        List<String> names = groceryDAO.getNames();
//
//        System.out.println(names);
//
//        GroceryDAO dao=new GroceryDaoImpl();
//        dao.updateQuantity();



    }
}

