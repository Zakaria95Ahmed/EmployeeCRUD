package com.employee.crud.service;

import com.employee.crud.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Optional<Employee> find(Long id);

    List<Employee> findAll();

    List<Employee> findAll(Sort sort);

    Page<Employee> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Employee employee);

    void deleteAll();

    long count();

//    Optional<Employee> getEmployeeById(Long id);
}