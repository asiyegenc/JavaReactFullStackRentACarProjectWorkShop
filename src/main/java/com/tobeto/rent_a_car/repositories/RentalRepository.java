package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository  <Rental, Integer> {
}
