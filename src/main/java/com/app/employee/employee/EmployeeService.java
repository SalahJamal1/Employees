package com.app.employee.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(Integer id);

    void delete(Employee employee);

}
