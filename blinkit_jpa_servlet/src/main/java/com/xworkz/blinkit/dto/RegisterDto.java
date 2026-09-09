package com.xworkz.blinkit.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String name;

    private  Long phNumber;

    private String email;

    private String password;

}
