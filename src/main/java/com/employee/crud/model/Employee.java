package com.employee.crud.model;


import lombok.*;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;


    @Column(name = "email_id")
    private String email;


    @Column(name = "password")
    private String password;

    @Column(name = "Date_of_birth")
    private Date dateOfBirth;


    @Column(name = "GENDER")
    private String gender;

    @Column(name = "phone_number")
    private String phone;


    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE },
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_role",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();



}

