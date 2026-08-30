package com.xworkz.cloud.device.dao;

import com.xworkz.cloud.device.entity.SignupEntity;

import java.util.List;

public interface SignupDAO {

    boolean save(SignupEntity signupEntity);

Boolean saveAll(List<SignupEntity> list);

 SignupEntity getByid(Integer id);

 List<SignupEntity> readAllSignupEntity();

 List<SignupEntity> getSignupById(int id);

 List<SignupEntity> getSignupByPassword(String password);

 List<SignupEntity> getSignupByEmail(String email);

 List<SignupEntity> getSignupByPasswordAndEmail(String password, String email);

}
