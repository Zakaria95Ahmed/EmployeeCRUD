package com.employee.crud.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeePrincipal implements UserDetails {


    private Employee employee;

    @Autowired
    public EmployeePrincipal(Employee employee) {
        this.employee = employee;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        employee.getRoles().forEach(
                temp -> {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(temp.getNameRole());
                    authorities.add(grantedAuthority);
                }
        );
        return authorities;
    }



    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getUserName();
    }


    public String getUserEmail() {
        return employee.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





}
