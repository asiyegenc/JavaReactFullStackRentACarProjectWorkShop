package com.tobeto.rent_a_car.services.dtos.paymentMethod.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPaymentMethodResponse {
    private int id;
    private String paymentType;
}
