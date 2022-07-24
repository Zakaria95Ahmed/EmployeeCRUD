package com.employee.crud.controller;

import com.employee.crud.JWTUtility.JwtLogin;
import com.employee.crud.JWTUtility.LoginResponse;
import com.employee.crud.exception.ResourceNotFoundException;
import com.employee.crud.model.Employee;
//import com.employee.crud.service.EmployeeService;
import com.employee.crud.service.EmployeeServiceImpl;
import com.employee.crud.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private TokenService tokenService;
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(TokenService tokenService, EmployeeServiceImpl employeeService) {
        this.tokenService = tokenService;
        this.employeeService = employeeService;
    }

    // create or save employee object rest api
    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }


    //http://localhost:8181/api/v1/register
    @PostMapping("/register")
    //@CrossOrigin(origins = "http://localhost:4200")
    public Employee registerUser(@RequestBody Employee user) throws Exception {
        String tempEmail1 = user.getEmail();
        if (tempEmail1 != null && !"".equals(tempEmail1)) {
            Employee user1 = employeeService.findByEmail(tempEmail1);
            if (user1 != null) {
                throw new Exception("User With " + tempEmail1 + "is Already Exist.!");
            }
        }
        Employee user2 = null;
        user2 = employeeService.saveEmployee(user);
        return user2;
    }


    //http://localhost:8181/api/v1/login
    @PostMapping("/login")
    //@CrossOrigin(origins = "http://localhost:4200")
    public Employee loginUser(@RequestBody Employee user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPass = user.getPassword();
        Employee userObj = null;
        if (tempEmail != null && tempPass != null) {
            userObj = employeeService.findEmployeeByEmailAndPassword(tempEmail, tempPass);
        }
        if (userObj == null) {
            throw new Exception("Oh ,Bad Credentials...");
        }
        return userObj;
    }



    // http://localhost:8080/api/v1/auth0/login
    @PostMapping("/auth0/login")
    public LoginResponse login(@RequestBody JwtLogin jwtLogin) throws Exception {
        return tokenService.login(jwtLogin);
    }



    @GetMapping("/employee/count")
    public long countEmployees(){
        return employeeService.count();
    }

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }


    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById1(@PathVariable(value = "id") Long id){
        return employeeService.find(id);
    }

    @GetMapping("/employee1/{id}")
    public String getEmployeeById2(@PathVariable(value = "id") Long id){
        return employeeService.find_ById(id);
    }



    // update employee rest api

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }


    // update employee rest api

    @PutMapping("/employee1")
    public String updateEmployee(@RequestBody Employee employee){

        return employeeService.update_Employee(employee);
    }




    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employe1 = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employe1.setFirstName(employeeDetails.getFirstName());
        employe1.setLastName(employeeDetails.getLastName());
        employe1.setEmail(employeeDetails.getEmail());
        employe1.setPassword(employeeDetails.getPassword());

        Employee updatedEmployee = employeeService.saveEmployee(employe1);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeService.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        employeeService.delete(id);
    }

    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") Long id){

        employeeService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAll() {
        this.employeeService.deleteAll();
    }























}