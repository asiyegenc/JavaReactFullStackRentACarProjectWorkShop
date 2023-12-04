package com.tobeto.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name="payment_methods")
@Entity
@Getter
@Setter
public class PaymentMethod {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="payment_type")
    private String paymentType;
    @Column(name="card_holder_name")
    private String cardHolderName;
    @Column(name="card_number")
    private String cardNumber;
    @Column(name="expiration_date")
    private LocalDate expirationDate;
    @Column(name="cvv")
    private Integer cvv;

    @OneToMany(mappedBy = "paymentMethod")
    @JsonIgnore
    private List<Rental> rentals;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}
