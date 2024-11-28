package com.Employee.Employee.service;

import com.Employee.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findBy(Integer employeeId);

    void delete(Integer employeeId);

    Employee save(Employee employee);
}
