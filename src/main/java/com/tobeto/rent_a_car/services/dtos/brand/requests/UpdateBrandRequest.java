package com.tobeto.rent_a_car.services.dtos.brand.requests;

import lombok.Data;

@Data
public class UpdateBrandRequest {
    private int id;
    private String name;
}