package com.tobeto.rent_a_car.services.dtos.price.requests;

import jakarta.validation.constraints.NotNull;

public class DeletePriceRequest {
    @NotNull(message = "ID boş olamaz")
    private int id;
}
