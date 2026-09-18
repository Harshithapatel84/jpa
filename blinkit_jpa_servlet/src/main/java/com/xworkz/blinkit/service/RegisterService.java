package com.xworkz.blinkit.service;

import com.xworkz.blinkit.dto.RegisterDto;
import com.xworkz.blinkit.entity.RegisterEntity;

import java.util.List;

public interface RegisterService {

    String save(RegisterDto dto);

    List<RegisterDto> validateAndGetAllRegister();

}
