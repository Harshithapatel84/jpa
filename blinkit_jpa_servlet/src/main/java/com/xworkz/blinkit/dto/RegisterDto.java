package com.xworkz.blinkit.dto;


import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private int id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "Phone number cannot be null")
    @Digits(integer = 10, fraction=0,message = "Enter a valid 10 digit phone number")
    private Long phNumber;

    @NotBlank(message = "enter a valid email")
    private String email;

    @NotBlank(message = "password should contaion 5 characters")
    private String password;

}
