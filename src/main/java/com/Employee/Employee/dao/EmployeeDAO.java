package com.Employee.Employee.dao;

import com.Employee.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}
