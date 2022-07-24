//package com.employee.crud.dataTest;
//
//import com.employee.crud.model.Employee;
//import com.employee.crud.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Runner implements CommandLineRunner {
//
//    private EmployeeRepository employeeRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public Runner(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
//        this.employeeRepository = employeeRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//    @Override
//    public void run(String... args) throws Exception {
//        Employee employee = new Employee();
//        employee.setEmail("zakaria@gmail.com");
//        employee.setFirstName("Zakaria");
//        employee.setLastName("Ahmed");
//        employee.setUserName("Zagzag");
//        employee.setPhone("0123456789");
//        employee.setGender("Male");
////      employee.setDateOfBirth("12","12","2000");
//        employee.setPassword(passwordEncoder.encode("zagzag123"));
//        employeeRepository.save(employee);
//        Employee employee1 = new Employee();
//        employee1.setEmail("ahmed@gmail.com");
//        employee1.setFirstName("Diaa");
//        employee1.setLastName("Ahmed");
//        employee1.setUserName("Zagzag");
//        employee1.setPassword(passwordEncoder.encode("ahmed123"));
//        employeeRepository.save(employee1);
//    }
//
//
//
//
//}
