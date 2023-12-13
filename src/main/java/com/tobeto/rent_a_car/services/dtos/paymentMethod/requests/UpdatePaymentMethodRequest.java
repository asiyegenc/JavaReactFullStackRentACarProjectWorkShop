package com.tobeto.rent_a_car.services.dtos.paymentMethod.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data

public class UpdatePaymentMethodRequest {

    @NotNull(message = "ID boş olamaz")
    private int id;

    @NotBlank(message = "Ödeme tipi boş olamaz")
    private String paymentType;
}