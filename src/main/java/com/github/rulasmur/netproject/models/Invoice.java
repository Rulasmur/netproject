package com.github.rulasmur.netproject.models;

import javax.persistence.*;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private Person person;
}
