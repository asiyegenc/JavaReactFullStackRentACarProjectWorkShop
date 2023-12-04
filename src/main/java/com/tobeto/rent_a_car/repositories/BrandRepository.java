package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository <Brand, Integer> {
}
