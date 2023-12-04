package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
}
