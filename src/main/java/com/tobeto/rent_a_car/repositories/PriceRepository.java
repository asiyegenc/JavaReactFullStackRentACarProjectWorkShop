package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository <Price, Integer> {
}
