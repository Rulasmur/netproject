package com.github.rulasmur.netproject.models;

import javax.persistence.Entity;

@Entity
public class Client extends Person{

    private String vatNumber;
    private String contactPerson;
    private String accountNumber;
    private String position;

}
