
        package com.xworkz.mart.product.service.impl;

import com.xworkz.mart.product.dao.GroceryDAO;
import com.xworkz.mart.product.dao.impl.GroceryDaoImpl;
import com.xworkz.mart.product.dto.GroceryDTO;
import com.xworkz.mart.product.entity.GroceryEntity;
import com.xworkz.mart.product.service.GroceryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroceryServiceImpl implements GroceryService {

    GroceryDAO dao = new GroceryDaoImpl();


    @Override
    public Boolean save(GroceryDTO groceryDTO) {

        System.out.println("invoking saveGrocery:GroceryServiceImpl");

        String isSaved = null;

        if (groceryDTO != null) {

            GroceryEntity entity = new GroceryEntity();

            entity.setName(groceryDTO.getName());
            entity.setPrice(groceryDTO.getPrice());
            entity.setBrand(groceryDTO.getBrand());

            Boolean saved = dao.save(entity);

            if (saved) {
                isSaved = "data saved";
            } else {
                isSaved = "data not saved";
            }

        } else {

            isSaved = "data is empty";
        }

        return false;
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
    public GroceryDTO findByname(String name) {

        System.out.println("invoking getGroceryByName:GroceryServiceImpl");

        GroceryEntity entity = dao.getGroceryEntitybyName(name);

        if (entity != null) {

            GroceryDTO dto = new GroceryDTO();

            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setBrand(entity.getBrand());

            return dto;
        }

        return null;
    }


    @Override
    public List<GroceryDTO> readAllGroceryDto() {

        System.out.println(
                "invoking readAll GroceryDto:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.readAllGroceryEntity();

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByNameDto(String name) {

        System.out.println(
                "invoking getGroceryByNameDto:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByName(name);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByBrand(String brand) {

        System.out.println(
                "invoking getGroceryByBrand:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByBrand(brand);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByPrice(Double price) {

        System.out.println(
                "invoking getGroceryByPrice:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByPrice(price);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByNameAndBrand(
            String name, String brand) {

        System.out.println(
                "invoking getGroceryByNameAndBrand:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByNameAndBrand(name, brand);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByPriceGreaterThan(
            Double price) {

        System.out.println(
                "invoking getGroceryByPriceGreaterThan:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByPriceGreaterThan(price);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByPriceLessThan(
            Double price) {

        System.out.println(
                "invoking getGroceryByPriceLessThan:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByPriceLessThan(price);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

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
    public List<GroceryDTO> getGroceryByBrandAndPrice(
            String brand, Double price) {

        System.out.println(
                "invoking getGroceryByBrandAndPrice:GroceryServiceImpl");

        List<GroceryEntity> groceryEntities =
                dao.getGroceryByBrandAndPrice(brand, price);

        List<GroceryDTO> groceryDTOs =
                new ArrayList<>();

        for (GroceryEntity entity : groceryEntities) {

            GroceryDTO dto = new GroceryDTO();

            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setBrand(entity.getBrand());

            groceryDTOs.add(dto);
        }

        return groceryDTOs;
    }

}

