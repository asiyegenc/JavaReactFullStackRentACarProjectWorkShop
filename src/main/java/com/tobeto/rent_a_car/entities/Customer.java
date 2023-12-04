package com.tobeto.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="customers")
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private Short age;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Rental> rentals;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<PaymentMethod> paymentMethods;
}
