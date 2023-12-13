package com.tobeto.rent_a_car.services.dtos.color.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DeleteColorRequest {
    @NotNull(message = "Id boş olamaz")
    @Positive(message = "Id 0'dan büyük olmalıdır")
    private int id;
}
