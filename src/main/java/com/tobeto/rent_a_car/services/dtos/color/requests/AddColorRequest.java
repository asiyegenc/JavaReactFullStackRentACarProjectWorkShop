package com.tobeto.rent_a_car.services.dtos.color.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddColorRequest {

    @NotNull(message = "Id boş olamaz")
    @Positive(message = "Id 0'dan büyük olmalıdır")
    private int id;

    @NotBlank(message = "Renk boş olamaz")
    private String color;
}