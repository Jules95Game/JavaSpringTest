package com.oefening.HelloWorld.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long amtEmployees;
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

    public Company() {
    }

    public Company(String name, long amtEmployees) {
        this.name = name;
        this.amtEmployees = amtEmployees;
    }

    public String getName() {
        return name;
    }

    public long getAmtEmployees() {
        return amtEmployees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmtEmployees(long amtEmployees) {
        this.amtEmployees = amtEmployees;
    }
}
