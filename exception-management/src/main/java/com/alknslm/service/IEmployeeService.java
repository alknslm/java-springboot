package com.alknslm.service;

import com.alknslm.dto.DtoEmployee;

public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);
}
