package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository  <PaymentMethod, Integer> {
}
