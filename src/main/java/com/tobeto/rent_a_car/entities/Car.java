package com.tobeto.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="cars")
@Entity
@Getter
@Setter
public class Car {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="model_year")
    private int modelYear;
    @Column(name="model_name")
    private String modelName;
    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name="price_id")
    private Price price;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

    @ManyToOne  // tekil ise join colonunu belirtmemiz lazım (fk kolonu)
    @JoinColumn(name="type_id")
    private Type type;

    @OneToMany(mappedBy = "car")
    @JsonIgnore //Sonsuz döngüyü kırmak için list olan alanlara (OneToMany) @JsonIgnore ekledik
    private List<Rental> rentals;
    // tekil ise join colonunu belirtmem lazım (fk kolonu)
}
