package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository  <Type, Integer> {
}
