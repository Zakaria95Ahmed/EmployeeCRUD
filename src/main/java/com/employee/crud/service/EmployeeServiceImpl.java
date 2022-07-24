package com.employee.crud.service;

import com.employee.crud.model.Employee;
import com.employee.crud.model.EmployeePrincipal;
import com.employee.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService , UserDetailsService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByEmail(email);
        EmployeePrincipal employeePrinciple = new EmployeePrincipal(employee);
        return employeePrinciple;
    }


    public boolean ifEmailExist(String mail){
        return employeeRepository.existsByEmail(mail);
    }

    public Employee getEmployeeByMail(String mail){
        return employeeRepository.findEmployeeByEmail(mail);
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    public String update_Employee(Employee employee) {
        Optional<Employee> employees = this.findEmployeeById(employee.getId());
        if (employees.isPresent()) {
            this.employeeRepository.save(employee);
            return "Employee No"+employee.getId()+"Updated Successfully .!";
        } else {
            return  "Employee No"+employee.getId()+"Not Found.!";
        }
    }



    @Override
    public Optional<Employee> find(Long id) {
        return Optional.empty();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public String find_ById(Long id) {
        Optional<Employee> employees = this.findEmployeeById(id);
        if (employees.isPresent()) {
             this.employeeRepository.findById(id);
           return "Already Exist.!";
        } else {
            return  "this Employee's Id  Not Found.!";
        }
    }



    public Employee findByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    public Employee findEmployeeByEmailAndPassword(String email,String password) {
        return employeeRepository.findEmployeeByEmailAndPassword(email,password);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAll(Sort sort){
        return employeeRepository.findAll(sort);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    employeeRepository.deleteById(id);
    }


    public String deleteById(Long id) {

        Optional< Employee> employee = this.findEmployeeById(id);
        if (employee.isPresent()){
            this.employeeRepository.deleteById(employee.get().getId());
            return "Employee Deleted .";}
        else{
            return "Employee does not exist.!";
        }

    }




    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }




}