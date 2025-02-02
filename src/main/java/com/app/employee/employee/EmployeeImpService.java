package com.app.employee.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeImpService implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.of(employeeRepository
                        .findById(id))
                .orElseThrow(() -> new RuntimeException("we can not found the id"));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Employee employee) {
        employeeRepository.delete(employee);

    }
}
