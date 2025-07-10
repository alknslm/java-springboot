package com.alknslm.controller;

import com.alknslm.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alknslm.services.EmployeeService;

import java.util.List;

@RestController
// ortak kök adresi için kullanılır. Aşağıda birden fazla method olursa -> localhost:8080/rest/api/employee-list
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    /**Controller'ı service bağladık*/
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list") //dışarıdan gelen istek url'i nasıl olacak
    public List<Employee> getAllEmployeeList() {
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list/{id}")
    //@PathVariable ile Sana bir id gelecek ve bu id zorunlu olacak dedik.
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) int id) {
        return employeeService.getEmployeeById(id);
    }

    //requestparam'daki name'ler neyse url'de de aynı isimle geçmek zorunda
    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                                @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }
}
