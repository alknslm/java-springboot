package com.alknslm.controller.impl;

import com.alknslm.controller.IEmployeeController;
import com.alknslm.dto.DtoEmployee;
import com.alknslm.entities.RootEntity;
import com.alknslm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl extends RestBaseController implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    //METHOD ESKİ HALİ
    /*@GetMapping(path = "/list/{id}")
    @Override
    public DtoEmployee findEmployeeById(@PathVariable(name = "id") Long id) {
        return employeeService.findEmployeeById(id);
    }*/

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoEmployee> findEmployeeById(@PathVariable(name = "id") Long id) {
        return ok(employeeService.findEmployeeById(id));
    }
}
