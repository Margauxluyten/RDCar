package com.vdab.rdcar.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_car")
@Data
public class CarChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Cat")
    private String cat;
    @Column(name = "Brand")
    private String brand;
    @Column(name = "Model")
    private String model;
    @Column(name = "Pack")
    private String pack;
    @Column(name = "List_price_incl_real_VAT")
    private Double listPrice;
    @Column(name = "Benefit_in_kind_month")
    private Double benefit;
    @Column(name = "Amount_upgrade_incl_21_VAT")
    private Double upgrade;
    @Column(name = "Amount_Downgrade_incl_21_VAT")
    private Double downgrade;

}
