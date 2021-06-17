package com.vdab.rdcar.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class LeasedCar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;

    private String model;

    private Long mileage;

    private Long registrationDate;

    @ManyToOne
    private Employee employee;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private List<CarChoice> carChoices = new ArrayList<>();

}
