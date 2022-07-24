package com.employee.crud.service;

import com.employee.crud.model.Role;
import com.employee.crud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@Service
public class  RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role role) {
        return roleRepository.save(role);
    }


    public Optional<Role> find(Long id) {
        return roleRepository.findById(id);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Page<Role> findAll(Pageable pageable){
        return roleRepository.findAll(pageable);
    }


    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }


    public void deleteAllRoles() {
        roleRepository.deleteAll();
    }


    public long count() {
        return roleRepository.count();
    }





}