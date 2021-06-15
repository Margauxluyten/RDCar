package com.vdab.rdcar.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private int startDate;
    private int carCategory;

}
