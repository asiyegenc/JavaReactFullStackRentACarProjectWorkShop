package com.tobeto.rent_a_car.services.dtos.type.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTypeRequest {

    @NotNull(message = "ID boş olamaz")
    private int id;

    @NotBlank(message = "Name boş olamaz")
    private String name;
}