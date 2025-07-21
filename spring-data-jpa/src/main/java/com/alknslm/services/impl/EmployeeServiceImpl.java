package com.alknslm.services.impl;

import com.alknslm.dto.DtoDepartment;
import com.alknslm.dto.DtoEmployee;
import com.alknslm.entities.Department;
import com.alknslm.entities.Employee;
import com.alknslm.repository.EmployeeRepository;
import com.alknslm.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee getEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Employee dbEmployee = optional.get();
        Department dbDepartment = optional.get().getDepartment();

        BeanUtils.copyProperties(dbEmployee, dtoEmployee);
        BeanUtils.copyProperties(dbDepartment, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);
        return dtoEmployee;
    }

    @Override
    public List<DtoEmployee> findAllEmployees() {
        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        if(employeeList != null && !employeeList.isEmpty()){
            for (Employee employee : employeeList) {
                DtoEmployee dtoEmployee = new DtoEmployee();

                BeanUtils.copyProperties(employee, dtoEmployee);
                dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), employee.getDepartment().getDeparmentName()));
                dtoEmployeeList.add(dtoEmployee);
            }
        }else{
            return null;
        }

        return dtoEmployeeList;
    }
}
