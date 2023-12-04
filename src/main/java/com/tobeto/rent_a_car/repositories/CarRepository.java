package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <Car, Integer> {
}
