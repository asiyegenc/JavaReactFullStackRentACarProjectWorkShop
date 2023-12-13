package com.tobeto.rent_a_car.services.dtos.rental.requests;

import jakarta.validation.constraints.NotNull;

public class DeleteRentalRequest {
    @NotNull(message = "ID boş olamaz")
    private int id;
}
