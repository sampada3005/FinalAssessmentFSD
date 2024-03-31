package com.example.FinalProject.controllers;

import com.example.FinalProject.model.Employee;
import com.example.FinalProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

   @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/")
    public  Employee createEmployee(@RequestBody Employee employee){
       return employeeService.create(employee);
    }

    @GetMapping("/search/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }
}
