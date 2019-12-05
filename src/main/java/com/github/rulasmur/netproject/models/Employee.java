package com.github.rulasmur.netproject.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Employee extends Person{

    @NotNull
    private String employeeNumber;
    @ManyToOne
    private Position position;
}
