package com.tobeto.rent_a_car.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name="Rentals")
@Entity
@Getter
@Setter
public class Rental {

    @Id   // eğer primary key (PK) ise bu şekilde belirtmemiz gerekiyor
    @Column(name="id") //name  = kolon adı
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  //classın içindeki alanın adı

    @Column(name="rental_date")
    private LocalDate rentalDate;
    @Column(name="return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="payment_method_id")
    private PaymentMethod paymentMethod;
}
