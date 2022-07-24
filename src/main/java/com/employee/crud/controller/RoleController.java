package com.employee.crud.controller;

import com.employee.crud.model.Role;
import com.employee.crud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2/")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role")
    public Role save(@RequestBody Role role){
        return roleService.save(role);
    }

    @GetMapping("/role/{id}")
    public Optional<Role> getById(@PathVariable(value = "id") Long id){
        return roleService.find(id);
    }

    @GetMapping("/role")
    public List<Role> getAll(){
        return roleService.findAllRoles();
    }

    @DeleteMapping("/role/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        roleService.deleteRole(id);
    }

    @DeleteMapping("/role")
    public void deleteAll(){
        roleService.deleteAllRoles();
    }

    @GetMapping("/role/count")
    public long count(){
        return roleService.count();
    }





}