package com.alknslm.repository;

import com.alknslm.model.Employee;
import com.alknslm.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList; //AppConfig içerisinde oluşturduğumuz Bean'e gidiyor.

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        Employee foundEmployee = null;
        for (Employee employee : employeeList) {
            if(employee.getId() == id) {
                foundEmployee = employee;
                break;
            }
        }
        return foundEmployee;
    }
    
    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if(firstName == null && lastName == null) {
            return employeeList;
        }

        for(Employee employee : employeeList) {
            if(firstName != null && lastName != null) {
                if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }

            if(firstName != null && lastName== null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }
            }
            if(lastName != null && firstName == null){
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
        }

        return employeeWithParams;
    }

    public Employee saveEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(int id) {
        for (Employee employee : employeeList) {
            if(id == employee.getId()){
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee updateEmployee(int id ,UpdateEmployeeRequest newEmployee) {
        Employee foundEmployee = getEmployeeById(id);
        if(foundEmployee != null){
            foundEmployee.setFirstName(newEmployee.getFirstName());
            foundEmployee.setLastName(newEmployee.getLastName());
        }
        return foundEmployee;
    }
}
