package com.alknslm.service.impl;

import com.alknslm.dto.DtoDepartment;
import com.alknslm.dto.DtoEmployee;
import com.alknslm.entities.Department;
import com.alknslm.entities.Employee;
import com.alknslm.repository.EmployeeRepository;
import com.alknslm.service.IEmployeeService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
        Optional<Employee> optional = employeeRepository.findById(id);

        if(optional.isEmpty()){
            return null;
        }

        Employee dbEmployee = optional.get();
        Department dbDepartment = dbEmployee.getDepartment();

        BeanUtils.copyProperties(dbDepartment, dtoDepartment);
        BeanUtils.copyProperties(dbEmployee, dtoEmployee);

        dtoEmployee.setDepartment(dtoDepartment);
        return dtoEmployee;
    }
}
