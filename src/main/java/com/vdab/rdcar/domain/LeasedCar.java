package com.vdab.rdcar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class LeasedCar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private Long mileage;

    @Enumerated(EnumType.STRING)
    private Colour colour;

    @Transient
    private Long ageOfCar;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    public Long getAgeOfLeasedCar(){
        if (registrationDate != null) {
            LocalDate today = LocalDate.now();
            this.ageOfCar = ChronoUnit.YEARS.between(this.registrationDate, today);
            return ageOfCar;
        }else{
            return ageOfCar;
        }
    }

    @ManyToOne
    private Employee employee;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CarChoice> carChoices;


}
