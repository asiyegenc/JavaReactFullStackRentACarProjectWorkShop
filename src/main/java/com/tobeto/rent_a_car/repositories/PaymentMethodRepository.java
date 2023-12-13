package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.PaymentMethod;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethodResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository  <PaymentMethod, Integer> {
    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethodResponse(pm.id, pm.paymentType) FROM PaymentMethod pm WHERE pm.paymentType LIKE %:paymentType%")
    List<GetListPaymentMethodResponse> getByPaymentTypeLike(@RequestParam String paymentType);
}
