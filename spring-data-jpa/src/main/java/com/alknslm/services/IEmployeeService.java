package com.alknslm.services;

import com.alknslm.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {

    public DtoEmployee getEmployeeById(Long id);

    public List<DtoEmployee> findAllEmployees();
}
