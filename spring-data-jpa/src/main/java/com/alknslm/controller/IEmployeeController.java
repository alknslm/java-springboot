package com.alknslm.controller;

import com.alknslm.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {

    public DtoEmployee getEmployeeById(Long id);

    public List<DtoEmployee> findAllEmployees();
}
