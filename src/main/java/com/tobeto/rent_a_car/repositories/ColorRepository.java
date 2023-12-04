package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository <Color, Integer> {
}
