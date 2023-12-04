package com.tobeto.rent_a_car.services.dtos.type.requests;

import lombok.Data;

@Data
public class UpdateTypeRequest {

    private int id;

    private String name;
}