package com.alknslm.controller;

import com.alknslm.dto.DtoEmployee;
import com.alknslm.entities.RootEntity;

public interface IEmployeeController {

    public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
