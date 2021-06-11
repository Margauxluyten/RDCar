package com.vdab.rdcar.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;

    private int startDate;

    private int carCategory;

}
