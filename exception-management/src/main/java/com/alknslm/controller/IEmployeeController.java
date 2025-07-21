package com.alknslm.controller;

import com.alknslm.dto.DtoEmployee;

public interface IEmployeeController {

    public DtoEmployee findEmployeeById(Long id);
}
