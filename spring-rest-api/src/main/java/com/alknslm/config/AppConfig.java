package com.alknslm.config;

import com.alknslm.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Ahmet","Çevik"));
        employeeList.add(new Employee(2,"Mehmet","Yılmaz"));
        employeeList.add(new Employee(3,"Sıla","Tezek"));
        employeeList.add(new Employee(4,"Recep","Hızlı"));
        employeeList.add(new Employee(5,"Yasin","Yazıcı"));

        return employeeList;
    }
}
