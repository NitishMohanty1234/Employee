package com.ProjectEmp.service;

import com.ProjectEmp.entity.Employee;
import com.ProjectEmp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Employeeservice {

    private final EmployeeRepository repository;

    public Employeeservice(EmployeeRepository repository) {
        this.repository = repository;
    }
    //create or save data
    public Employee SaveEmployee(Employee employee){
        return repository.save(employee);
    }

    //get or readAll
    public List<Employee> getEmployee(){
    return repository.findAll();
    }
    //Read by Id one by one
    public Optional<Employee> getEmployeeById(Long id){
        return repository.findById(id);
    }

    public Employee updateEmployee(Long id,Employee employee){
        Employee e= repository.findById(id).orElse(null);
        if(e != null){
            e.setName(employee.getName());
            e.setEmail(employee.getEmail());
            e.setSalary(employee.getSalary());
            e.setDepartment(employee.getDepartment());
            return repository.save(e);
        }
        return null;

    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }

}
