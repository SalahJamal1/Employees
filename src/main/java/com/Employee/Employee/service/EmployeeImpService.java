package com.Employee.Employee.service;

import com.Employee.Employee.dao.EmployeeDAO;
import com.Employee.Employee.entity.Employee;
import com.Employee.Employee.exception.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpService implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeImpService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;

    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findBy(Integer employeeId) {
        Optional<Employee> optional = employeeDAO.findById(employeeId);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new ErrorNotFoundException("We can't found the id " + employeeId);
    }

    @Override
    @Transactional
    public void delete(Integer employeeId) {
        Optional<Employee> optional = employeeDAO.findById(employeeId);
        if (optional.isPresent()) {
            employeeDAO.delete(optional.get());
        } else throw new ErrorNotFoundException("We can't found the id " + employeeId);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
}
