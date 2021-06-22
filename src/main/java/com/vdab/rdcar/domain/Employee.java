package com.vdab.rdcar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private String carCategory;
    @Transient
    private Long yearsEmployment;

    public Long getYearsEmployment() {
        if (startDate != null) {
            LocalDate today = LocalDate.now();
            this.yearsEmployment = ChronoUnit.YEARS.between(this.startDate, today);
            return yearsEmployment;
        }else{
            return yearsEmployment;
        }
    }



}
