package com.Employee.Employee.controller;

import com.Employee.Employee.entity.Employee;
import com.Employee.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @GetMapping("/list/{employeeId}")
    public Employee employee(@PathVariable Integer employeeId) {
        return employeeService.findBy(employeeId);
    }

    @PostMapping("/list/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PatchMapping("/list/update")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @DeleteMapping("/list/delete")
    public String DeleteEmployee(@PathVariable Integer employeeId) {
        Employee employee = employeeService.findBy(employeeId);
        employeeService.delete(employeeId);
        return "we delete the employee " + employee.getFirst_name();
    }
}
