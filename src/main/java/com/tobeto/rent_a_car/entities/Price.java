package com.tobeto.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="prices")
@Entity
@Getter
@Setter
public class Price {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="hourly_fee")
    private Double hourlyFee;

    @Column(name="daily_fee")
    private Double dailyFee;

    @Column(name="weekly_fee")
    private Double weeklyFee;

    @Column(name="mountly_fee")
    private Double mountlyFee;

    @OneToMany(mappedBy ="price")
    @JsonIgnore
    private List<Car> cars;
}
