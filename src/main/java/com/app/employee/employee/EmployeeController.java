package com.app.employee.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor

public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee employee(@PathVariable Integer employeeId) {
        return employeeService.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("we can not found the id"));
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return employeeService.save(employee);
    }

    @PatchMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee) {
        Employee employee1 = employeeService.findById(employeeId).orElseThrow(() -> new RuntimeException("we can not found the id"));
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        return employeeService.save(employee1);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        Employee employee1 = employeeService.findById(employeeId).orElseThrow(() -> new RuntimeException("we can not found the id"));

        employeeService.delete(employee1);
        return "the user deleted" + " " + employee1.getEmail();
    }


}
