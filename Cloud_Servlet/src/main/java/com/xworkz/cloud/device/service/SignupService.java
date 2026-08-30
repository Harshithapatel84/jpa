package com.xworkz.cloud.device.service;

import com.xworkz.cloud.device.dto.SignupDTO;

import java.util.List;

public interface SignupService {
    String save(SignupDTO dto);

    String saveAll(List<SignupDTO> list);

    SignupDTO getById(Integer id);

    List<SignupDTO> readAllSignupDto();

    List<SignupDTO> getSignupById(Integer id);

    List<SignupDTO> getSignupByPassword(String password);

    List<SignupDTO> getSignupByEmail(String email);

    List<SignupDTO> getSignupByPasswordAndEmail(String password, String email);
}
