package com.xworkz.cloud.device.service;

import com.xworkz.cloud.device.dto.SignupDTO;

import java.util.List;

public interface SignupService {
    String save(SignupDTO dto);

    String saveAll(List<SignupDTO> list);

    SignupDTO getById(Integer id);

    List<SignupDTO> readAllSignupDto();

    SignupDTO getSignupByMail(String mail);

    SignupDTO getSignupByPassword(String password);

    List<SignupDTO> getSignupByPasswordAndEmail( String password, String email);

    List<SignupDTO> getSignupByPasswordOrEmail( String password, String email);

    List<SignupDTO> getSignupByPasswordAndConfirmPassword( String password, String confirmPassword);

    String updatePasswordById(String password, int id);

    String updatePasswordConfirmPasswordById(String password, String confirmPassword, int id);

    String updatePasswordByEmail(String password, String email);


    }
