package com.ProjectEmp.controller;

import com.ProjectEmp.entity.Employee;
import com.ProjectEmp.service.Employeeservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @RestController
    @RequestMapping("/api/employees")

    public class employeecontroller {

        private final Employeeservice service;

        // Constructor Injection
        public employeecontroller(Employeeservice service) {
            this.service = service;
        }

        // CREATE - POST
        @PostMapping
        public Employee SaveEmployee(@RequestBody Employee employee) {
            return service.SaveEmployee(employee);
        }

        // READ ALL - GET
        @GetMapping
        public List<Employee> getAllEmployee() {
            return service.getEmployee();
        }

        // READ BY ID - GET
        @GetMapping("/{id}")
        public Optional<Employee> getEmployeeById(@PathVariable Long id) {
            return service.getEmployeeById(id);
        }

        // UPDATE - PUT
        @PutMapping("/{id}")
        public Employee updateEmployee(@PathVariable Long id,
                                       @RequestBody Employee employee) {
            return service.updateEmployee(id, employee);
        }

        // DELETE - DELETE
        @DeleteMapping("/{id}")
        public void deleteEmployee(@PathVariable Long id) {
            service.deleteEmployee(id);
        }
    }

}
