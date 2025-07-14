package com.alknslm.services;

import com.alknslm.model.Employee;
import com.alknslm.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alknslm.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList() {
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee newEmployee) {
        return employeeRepository.saveEmployee(newEmployee);
    }

    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(int id, UpdateEmployeeRequest newEmployee) {
        return employeeRepository.updateEmployee(id, newEmployee);
    }
}
