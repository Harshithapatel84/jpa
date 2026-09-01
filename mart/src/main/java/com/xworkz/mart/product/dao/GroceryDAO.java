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


}
