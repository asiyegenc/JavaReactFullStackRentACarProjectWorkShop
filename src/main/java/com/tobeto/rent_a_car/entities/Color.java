package com.tobeto.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="colors")
@Entity
@Getter
@Setter
public class Color {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="color")
    private String color;

    @OneToMany(mappedBy ="color")
    @JsonIgnore
    private List<Car> cars;
}
