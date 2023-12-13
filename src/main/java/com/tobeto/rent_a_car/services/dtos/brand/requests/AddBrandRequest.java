package com.tobeto.rent_a_car.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddBrandRequest {
    @NotBlank(message = "Marka adı boş olamaz")
    private String name;




}