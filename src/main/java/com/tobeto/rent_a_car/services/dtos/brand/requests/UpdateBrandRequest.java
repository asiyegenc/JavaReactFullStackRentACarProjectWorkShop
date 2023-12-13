package com.tobeto.rent_a_car.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBrandRequest {
    @NotNull(message = "ID numarası boş olamaz")
    private int id;

    @NotBlank(message = "Marka ismi boş olamaz")
    private String name;
}