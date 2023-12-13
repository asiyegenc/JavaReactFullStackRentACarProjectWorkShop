package com.tobeto.rent_a_car.services.dtos.brand.requests;

import jakarta.validation.constraints.Positive;

public class DeleteBrandRequest {
    @Positive(message = "ID negatif olamaz")
    private int id;
}
