
        package com.xworkz.mart.product.service.impl;

import com.xworkz.mart.product.dao.GroceryDAO;
import com.xworkz.mart.product.dao.impl.GroceryDaoImpl;
import com.xworkz.mart.product.dto.GroceryDTO;
import com.xworkz.mart.product.entity.GroceryEntity;
import com.xworkz.mart.product.service.GroceryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GroceryServiceImpl implements GroceryService {

    GroceryDAO dao = new GroceryDaoImpl();


    @Override
    public Boolean save(GroceryDTO groceryDTO) {

        System.out.println("invoking saveGrocery:GroceryServiceImpl");

        Boolean isSaved = null;

        if (groceryDTO != null) {

            GroceryEntity entity = new GroceryEntity();

            entity.setName(groceryDTO.getName());
            entity.setPrice(groceryDTO.getPrice());
            entity.setBrand(groceryDTO.getBrand());

            Boolean saved = dao.save(entity);

            if (saved) {
                isSaved = true;
            } else {
                isSaved = false;
            }

        } else {

            isSaved = false;
        }

        return isSaved;
    }


    @Override
    public String saveAll(List<GroceryDTO> list) {

        System.out.println("invoking saveAll:GroceryServiceImpl");

        String isSaved = null;

        if (list != null) {

            List<GroceryEntity> groceryEntities = list.stream()
                    .map(groceryDTO -> new GroceryEntity(
                            groceryDTO.getName(),
                            groceryDTO.getPrice(),
                            groceryDTO.getBrand()))
                    .collect(Collectors.toList());

            Boolean status = dao.saveAll(groceryEntities);

            if (status) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }
        }

        return isSaved;
    }




    @Override
    public List<GroceryDTO> readAllGroceryDto() {

        System.out.println("invoking readAll GroceryDto:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities = dao.readAllGroceryEntity();

        List<GroceryDTO> groceryDTOs = new ArrayList<>();

        for (GroceryEntity entity : groceryEntities) {

            GroceryDTO dto = new GroceryDTO();

            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setBrand(entity.getBrand());

            groceryDTOs.add(dto);
        }

        return groceryDTOs;
    }

    @Override
    public GroceryDTO getByBrand(String brand) {
        System.out.println("invoking getByBrand");
        GroceryDTO dto=null;
        GroceryEntity findbyBrand=dao.getGroceryByBrand(brand);
        if(findbyBrand!=null){
            dto=new GroceryDTO(findbyBrand.getBrand(),findbyBrand.getPrice(),findbyBrand.getName());
        }
        return dto;
    }

    @Override
    public GroceryDTO getByName(String name) {
        System.out.println("invoking getByName");
        GroceryDTO dto=null;
        GroceryEntity finfByName=dao.getByName(name);
        if (finfByName != null) {
            dto=new GroceryDTO(finfByName.getBrand(),finfByName.getPrice(),finfByName.getName());
        }
        return dto;
    }

    @Override
    public List<GroceryDTO> getByBrandAndName(String name, String brand) {
        System.out.println("invoking getbynameandBrand");
        List<GroceryDTO> dto=null;
        List<GroceryEntity> findbynameAndbrand=dao.getgrocerybynameandbrand(name, brand);
        if(findbynameAndbrand!=null){
            dto = findbynameAndbrand.stream()
                    .map(entity -> new GroceryDTO(
                            entity.getName(),
                            entity.getPrice(),
                            entity.getBrand()))
                    .collect(Collectors.toList());
        }
        return dto;
    }

    @Override
    public List<GroceryDTO> getByBrandorPrice(String brand, Double price) {
        System.out.println("invoking getByBrandOrPrice");

        List<GroceryEntity> findByBrandOrPrice =dao.getgrocerybybrandorprice(brand, price);

        List<GroceryDTO> dto = null;

        if (findByBrandOrPrice != null) {

            dto = findByBrandOrPrice.stream()
                    .map(entity -> new GroceryDTO(
                            entity.getName(),
                            entity.getPrice(),
                            entity.getBrand()))
                    .collect(Collectors.toList());
        }

        return dto;
    }

    @Override
    public String updatepricebyname(Double price, String name) {
        System.out.println("invoking update price by name");
        String status=null;
        if(price!=0.0 && name!=null)
        {
            Boolean isUpdated=dao.updatepricebyname(price, name);
            if(isUpdated){
                status="data updated";
            }else {
                status="data not updated";
            }
        }
        return status;
    }
    @Override
    public String updatepricebybrandandname(
            Double price,
            String brand,
            String name) {

        System.out.println("invoking update price by brand and name");

        String status = null;

        if (price != null && price != 0.0
                && brand != null
                && name != null) {

            Boolean isUpdated =
                    dao.updatepricebybrandandname(price, brand, name);

            if (isUpdated) {
                status = "data updated";
            } else {
                status = "data not updated";
            }

        } else {
            status = "invalid data";
        }

        return status;
    }
    @Override
    public String updatebrandbyname(String brand, String name) {

        System.out.println("invoking update brand by name");

        String status = null;

        if (brand != null && name != null) {

            Boolean isUpdated =
                    dao.updatebrandbyname(brand, name);

            if (isUpdated) {
                status = "data updated";
            } else {
                status = "data not updated";
            }

        } else {
            status = "invalid data";
        }

        return status;
    }


}

