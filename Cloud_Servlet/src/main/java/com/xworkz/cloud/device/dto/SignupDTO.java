package com.xworkz.cloud.device.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SignupDTO {


    private String email;
    private String password;
    private String confirmPassword;



}