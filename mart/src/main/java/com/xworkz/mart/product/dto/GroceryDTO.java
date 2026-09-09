package com.xworkz.mart.product.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class GroceryDTO {

    @NotNull (message="name cann't ne null")
    @NotBlank(message = "provide name")
    private String name;

    @NotNull(message="price cann't be null")
    private Double price;

    private String brand;

    @NotNull(message = "quantity cannot be null")
    @Size(min=2,max = 50,message="quantity should be bettween 2 to 50")
    private  Double quantity;
}

