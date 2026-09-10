package com.xworkz.blinkit.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @NotBlank(message = "name is required")
    private String name;

    @Pattern(regexp = "^{10}",message = "enter a 10 digit valid phone number")
    private  Long phNumber;

    @NotBlank(message = "enter a valid email")
    @NotNull(message="email cannot be empty")
    private String email;

    @NotBlank(message = "password should contaion 5 characters")
    private String password;

}
