package com.xworkz.mart.product.dao;

import com.xworkz.mart.product.entity.GroceryEntity;

import java.util.List;

public interface GroceryDAO {


    Boolean save(GroceryEntity grocery);

    Boolean saveAll(List<GroceryEntity> groceryEntityList);

    List<GroceryEntity> readAllGroceryEntity();

    GroceryEntity getByName(String name);

    GroceryEntity getGroceryByBrand(String brand);

    List<GroceryEntity> getgrocerybynameandbrand(String name,String brand);

    List<GroceryEntity> getgrocerybybrandorprice(String brand,Double price);

    Boolean updatepricebyname(Double price,String name);

    Boolean updatepricebybrandandname(Double price, String brand, String name);

    Boolean updatebrandbyname(String brand, String name);

    List<String> getNames();

}
