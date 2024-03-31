package com.example.FinalProject.services;

import com.example.FinalProject.exceptions.EntityNotFoundException;
import com.example.FinalProject.model.Employee;
import com.example.FinalProject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        if(!employeeRepository.findAll().isEmpty()){
            return employeeRepository.findAll();
        }
        throw new EntityNotFoundException("Employees does not exist");

    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new EntityNotFoundException("Employee with given ID is not present");
    }

    public List<Employee> getEmployeeByName(String name){
        if(!employeeRepository.findByNameContainingIgnoreCase(name).isEmpty()){
            return employeeRepository.findByNameContainingIgnoreCase(name);
        }
        throw new EntityNotFoundException("Employees does not exist");

    }

    public Employee create(Employee employee){
            Employee newCustomer = employeeRepository.save(employee);
            return newCustomer;
    }
}
