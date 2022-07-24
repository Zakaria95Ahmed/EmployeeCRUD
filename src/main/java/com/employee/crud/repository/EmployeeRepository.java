package com.employee.crud.repository;

import com.employee.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    public String getEmployeeById(Long id);

    public Employee findEmployeeByEmail(String email);

    public Employee findEmployeeByEmailAndPassword(String email, String password);


    public boolean existsByEmail(String mail);

    //    Employee findByEmail(String mail);

}