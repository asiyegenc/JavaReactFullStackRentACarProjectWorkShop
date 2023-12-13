package com.tobeto.rent_a_car.services.dtos.paymentMethod.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddPaymentMethodRequest {

    @NotBlank(message = "Ödeme tipi boş olamaz")
    private String paymentType;
}