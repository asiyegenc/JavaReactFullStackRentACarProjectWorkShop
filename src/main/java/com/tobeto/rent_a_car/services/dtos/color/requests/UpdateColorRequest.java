package com.tobeto.rent_a_car.services.dtos.color.requests;

import lombok.Data;

@Data
public class UpdateColorRequest {

    private int id;

    private String color;
}